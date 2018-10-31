package ru.sidorenko.jc.levelV;

public final class Tunnel extends Stage {

    public Tunnel() {
        this.length = 80;
        this.description = "Дорога " + length + " meter";
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " reading for stage(ready): " + description);
            System.out.println(c.getName() + " start stage: " + description);
            Thread.sleep(length / c.getSpeed() * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + " finished stage: " + description);
        }
    }

}
