package soo.joe.demo.java.lock;

import java.util.concurrent.locks.LockSupport;

/**
 * @author: suzhou
 * @createtime: 2019-03-26 15:10
 * @description: 自实现非可重入锁
 */
public class NoReentrantLock {
    /** 队列的头节点 */
    private volatile Node head;
    /** 队列的尾节点 */
    private volatile Node tail;
    /** 表示共享资源的状态 */
    private volatile int state;

    /**
     * 获取锁
     */
    public void lock(){
        //先尝试获取资源
        if(tryAcquire()){
            return;
        }

        //将当前线程封装成为一个节点
        Node node=new Node(Thread.currentThread());

        //把当前线程加入到队列末尾
        addWaiter(node);

        //如果不能获取到锁那么就挂起等待被唤醒
        acquireQueued();
    }

    /**
     * 解锁
     */
    public void unlock(){
        if(0!=state){
            this.state=0;
        }else {
            throw new IllegalStateException("illegal state:"+this.state);
        }
        //唤醒队列中下一个挂起的节点
        this.notifyNext();
    }

    /**
     * 唤醒下一个节点
     *
     * 1.获取头节点
     * 2.唤醒节点
     */
    private void notifyNext(){
        if(null ==head){
            return;
        }
        while(true){
            Node preHead=head;
            if(Cas.compareAndSetHead(this,preHead,preHead.next)){
                LockSupport.unpark(preHead.thread);
                break;
            }
        }
    }

    /**
     * 尝试获取锁
     *
     * 1.判断当前状态是否为已挂起
     * 2.然后通过cas算法进行状态更新
     * @return
     */
    private boolean tryAcquire(){
        //判断当前线程的状态
        if(0==this.state){
            if(Cas.compareAndSetState(this,0,1)){
                return true;
            }
        }
        return false;
    }


    /**
     * 获取锁
     *
     * 1.挂起线程
     * 2.通过cas获取锁
     * @return
     */
    private final boolean acquireQueued(){
        while (true){
            //挂起线程
            LockSupport.park(this);
            if(tryAcquire()){
                return true;
            }
        }
    }

    /**
     * 增加末尾节点
     *
     * 1.如果尾节点为空则进行cas设置，设置成功则将
     * @param node
     * @return
     */
    private Node addWaiter(Node node){
        while (true){
            Node t=tail;
            if(t==null){
                if(Cas.compareAndSetHead(this,null,node)){
                    tail=head;
                }
            }else {
                if(Cas.compareAndSetTail(this,t,node)){
                    t.next=node;
                    node.pre=t;
                    return t;
                }
            }
        }
    }
}
