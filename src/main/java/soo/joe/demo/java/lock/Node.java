package soo.joe.demo.java.lock;

/**
 * @author: suzhou
 * @createtime: 2019-03-26 15:11
 * @description: 等待队列节点
 */
public  class Node {
    /** 下一个节点**/
    protected Node next;
    /** 上一个节点**/
    protected Node pre;
    /** 保存在队列中挂起的线程 */
    protected Thread thread;


    public Node(Thread thread){
        this.thread=thread;
    }
}
