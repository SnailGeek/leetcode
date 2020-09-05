package test.asynchronous.transfer;

import java.util.concurrent.CountDownLatch;

/**
 * @program: BuyVegetables
 * @description:
 * @author: wangf-q
 * @date: 2020-01-16 15:33
 **/
public class BuyVegetables implements Runnable{
    private CountDownLatch countDownLatch;

    public BuyVegetables(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(5000);
            System.out.println("买完蔬菜");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (countDownLatch != null){
                countDownLatch.countDown();
            }
        }
    }
}
