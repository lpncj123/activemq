package cn.lp;

public class ThreadInterrupted {
  public static void main(String[] args) {
    Runnable runnable = () -> {
      while (true) {
        if(Thread.currentThread().isInterrupted()){
          System.out.println("线程被中断！");
          return;
        }else{
          System.out.println("线程没有被中断！");
        }
      }
    };
    Thread t  = new Thread(runnable);
    t.start();
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    t.interrupt();
    System.out.println("线程被interrupt中断");
  }
}
