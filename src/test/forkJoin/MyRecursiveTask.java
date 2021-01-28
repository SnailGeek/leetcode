package test.forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class MyRecursiveTask extends RecursiveTask<Integer> {
    private final int start, end;

    public MyRecursiveTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if (end - start <= 1000) {
            System.out.println(Thread.currentThread().getName() + "开始执行： " + start + "-" + end);
            return IntStream.rangeClosed(start, end).sum();
        } else {
            MyRecursiveTask leftTask = new MyRecursiveTask(start, (start + end) / 2);
            MyRecursiveTask rightTask = new MyRecursiveTask((start + end) / 2 + 1, end);
            leftTask.fork();
            rightTask.fork();
            return leftTask.join() + rightTask.join();
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Integer> task = new MyRecursiveTask(1, 10000);
        pool.submit(task);
        System.out.println(task.get());
    }
}