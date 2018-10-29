package ru.sidorenko.jc.levelIV;

public final class PrintThread {

    private boolean nextA = false;

    private boolean nextB = true;

    private boolean nextC = true;

    synchronized void printA() {
        try {
            for (int i = 0; i < 5; i++) {
                while (nextA) {
                    wait();
                }
                System.out.println("A");
                nextA = true;
                nextB = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void printB() {
        try {
            for (int i = 0; i < 5; i++) {
                while (nextB) {
                    wait();
                }
                System.out.println("B");
                nextB = true;
                nextC = false;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized void printC() {
        try {
            for (int i = 0; i < 5; i++) {
                while (nextC) {
                    wait();
                }
                System.out.println("C");
                nextC = true;
                nextA = false;
                notifyAll();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
