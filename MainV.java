package ru.sidorenko.jc.levelV;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class MainV {

    public static final int CARS_COUNT = 4;

    public static void main(String[] args) {
        CountDownLatch countDownLatchRoad = new CountDownLatch(8);
        CountDownLatch countDownLatchCar = new CountDownLatch(CARS_COUNT);

        System.out.println("Attention please >>> Reading!!!");
        Race race = new Race(new Road(60, countDownLatchRoad), new Tunnel(), new Road(40, countDownLatchRoad));
        Car[] cars = new Car[CARS_COUNT];

        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), countDownLatchCar);
        }

        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();
        }

        try {
            countDownLatchCar.await();
            System.out.println("Attention please >>> Start!!!");
            countDownLatchRoad.await();
            System.out.println("Attention please >>> Finish!!!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
