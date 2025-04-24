package cn.lp.completablefutureexample;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.completablefutureexample
 * @Author: lp
 * @CreateTime: 2024-05-22  13:53
 * @Description: TODO
 * @Version: 1.0
 */
public class ForkJoinSumExample {

    // 定义一个任务类，继承 RecursiveTask
    static class SumTask extends RecursiveTask<Long> {
        private final int[] array;
        private final int start;
        private final int end;
        private static final int THRESHOLD = 1000; // 阈值

        SumTask(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }
        //定义拆分逻辑
        @Override
        protected Long compute() {
            if (end - start <= THRESHOLD) {
                long sum = 0;
                for (int i = start; i < end; i++) {
                    sum += array[i];
                }
                return sum;
            } else {
                int middle = (start + end) / 2;
                SumTask leftTask = new SumTask(array, start, middle);
                SumTask rightTask = new SumTask(array, middle, end);

                // Fork the subtasks,提交给ForkJoinPool异步执行
                leftTask.fork();
                rightTask.fork();

                // Join the results
                long leftResult = leftTask.join();
                long rightResult = rightTask.join();

                return leftResult + rightResult;
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个包含 10000 个元素的数组
        int[] array = new int[10000];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // 创建一个 ForkJoinPool
        ForkJoinPool forkJoinPool = new ForkJoinPool();

        // 创建并执行 SumTask
        SumTask task = new SumTask(array, 0, array.length);
        long result = forkJoinPool.invoke(task);

        // 打印结果
        System.out.println("Sum: " + result);
    }
}