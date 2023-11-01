package cn.lp.concurrentart;

import java.util.concurrent.TimeUnit;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-10-27  18:18
 * @Description: TODO
 * @Version: 1.0
 */
public class Profiler {
    private  static final ThreadLocal<Long> TIME_THREADLOCAL = new ThreadLocal<Long>();
    protected  Long initialValue(){
        return System.currentTimeMillis();
    }
    public static final void begin(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final  long end(){
        return System.currentTimeMillis()-TIME_THREADLOCAL.get();
    }

    public static void main(String[] args) throws InterruptedException {
        Profiler.begin();
        TimeUnit.SECONDS.sleep(1);
        System.out.println(Profiler.end());
    }

}
