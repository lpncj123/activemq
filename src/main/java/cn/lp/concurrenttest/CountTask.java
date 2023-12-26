package cn.lp.concurrenttest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.concurrentart
 * @Author: lp
 * @CreateTime: 2023-11-07  10:56
 * @Description: TODO
 * @Version: 1.0
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    private CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
        } else {
            int middle = (end + start) / 2;
            CountTask leftTask = new CountTask(start, middle);
            CountTask rightTask = new CountTask(middle + 1, end);
            if(leftTask.isCompletedAbnormally()){
                System.out.println(leftTask.getException());
            }
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult = rightTask.join();
            sum = leftResult + rightResult;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 4);
        Future<Integer> result = forkJoinPool.submit(countTask);
        System.out.println(result.get());
    }
}
