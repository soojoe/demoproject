package soo.joe.demo.java.lock;

import sun.misc.Unsafe;
import java.lang.reflect.Field;

/**
 * @author: suzhou
 * @createtime: 2019-03-26 15:46
 * @description: CAS工具类
 */
public class Cas {
    /** unsafe实现了cas操作，cas是需要基于cpu指令实现的**/
    private static Unsafe unsafe;

    private static long tailOffset;
    private static long headOffset;
    private static long stateOffset;

    static {
        try{
            //此类非Java标准类，直接调用getUnsafe会报错，可以通过反射的方式获取到该类。
            Field f=Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe=(Unsafe)f.get(null);

            tailOffset=unsafe.objectFieldOffset(NoReentrantLock.class.getDeclaredField("tail"));
            headOffset=unsafe.objectFieldOffset(NoReentrantLock.class.getDeclaredField("head"));
            stateOffset=unsafe.objectFieldOffset(NoReentrantLock.class.getDeclaredField("state"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static final boolean compareAndSetTail(NoReentrantLock lock,Node expect,Node update){
        return unsafe.compareAndSwapObject(lock,tailOffset,expect,update);
    }

    public static final boolean compareAndSetHead(NoReentrantLock lock,Node expect,Node update){
        return unsafe.compareAndSwapObject(lock,headOffset,expect,update);
    }

    public static final boolean compareAndSetState(NoReentrantLock lock,int expect,int update){
        return unsafe.compareAndSwapInt(lock,stateOffset,expect,update);
    }
}
