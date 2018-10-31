package ru.sidorenko.jc.levelV;

import java.util.concurrent.CountDownLatch;

public final class Car implements Runnable {

    private static int CARS_COUNT;

    private final Race race;

    private final int speed;

    private final String name;

    private CountDownLatch countDownLatch;

    static {
        CARS_COUNT = 0;
    }

    public Car(Race race, int speed, CountDownLatch countDownLatch) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Sector #" + CARS_COUNT;
        this.countDownLatch = countDownLatch;
    }

    public int getSpeed() {
        return speed;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " reading");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " ready");
            countDownLatch.countDown();
            countDownLatch.await();
            Thread.sleep(1);
            for (int i = 0; i < race.getStages().size(); i++) {
                race.getStages().get(i).go(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
