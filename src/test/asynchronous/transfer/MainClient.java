package test.asynchronous.transfer;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @program: MainClient
 * @description:
 * @author: wangf-q
 * @date: 2020-01-16 15:34
 **/
public class MainClient {
    public static void main(String[] args) throws Exception{
        long now = System.currentTimeMillis();
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Executor executor = Executors.newFixedThreadPool(2);
        executor.execute(new BuySnacks(countDownLatch));
        executor.execute(new BuyVegetables(countDownLatch));
        countDownLatch.await();
        System.out.println("over, go home cost: " + (System.currentTimeMillis() - now));
    }
}
