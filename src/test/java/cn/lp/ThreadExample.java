package cn.lp;


import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ThreadPoolExecutor;

public class ThreadExample extends TestJunit{
    @Autowired
    private ThreadPoolExecutor threadPoolExecutor;
    private int a = 1;
    @Test
    public void testThreadPool(){
        for (int i = 0; i < 100; i++) {
            threadPoolExecutor.execute(() -> {
                int increase = increase();
                System.out.println(Thread.currentThread().getName()+"^^^^"+increase);
            });
        }

    }
    private synchronized  int increase(){
        a++;
        return a;
    }
}
