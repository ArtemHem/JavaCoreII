package ru.sidorenko.jc.levelV;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public final class Road extends Stage {

    private final CountDownLatch countDownLatch;

    public Road(int length, CountDownLatch countDownLatch) {
        this.length = length;
        this.description = "Road " + length + " meter";
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " start period: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
            System.out.println(c.getName() + " finish period: " + description);
            countDownLatch.countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
