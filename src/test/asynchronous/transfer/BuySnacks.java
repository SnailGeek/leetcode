package test.asynchronous.transfer;

import java.util.concurrent.CountDownLatch;

/**
 * @program: BuyVegetables
 * @description:
 * @author: wangf-q
 * @date: 2020-01-16 15:30
 **/
public class BuySnacks implements Runnable{
    private CountDownLatch countDownLatch;

    public BuySnacks(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("买完零食");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null){
                countDownLatch.countDown();
            }
        }
    }
}
