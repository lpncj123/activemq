package cn.lp.concurrenttest;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-16  15:52
 * @Description: TODO
 * @Version: 1.0
 */
public class BankWaterService implements Runnable{
//    创建4个屏障，处理完之后执行run方法
    private CyclicBarrier c = new CyclicBarrier(4,this);
//    假设有四个sheet，创建四个线程
    Executor executor = Executors.newFixedThreadPool(4);
    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();
    private  void count(){
        for (int i = 0; i < 4; i++) {
            executor.execute(()->{
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    c.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
    }
    @Override
    public void run() {
        int result =0;
        for(Map.Entry<String,Integer> sheet :sheetBankWaterCount.entrySet()){
            result+=sheet.getValue();
        }
        sheetBankWaterCount.put("result",result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
