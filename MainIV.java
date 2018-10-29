package ru.sidorenko.jc.levelIV;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainIV {

    public static void main(String[] args) {

        PrintThread newPrintThread = new PrintThread();
        ExecutorService executorService = Executors.newCachedThreadPool();

        try {
            executorService.submit(newPrintThread::printA);
            executorService.submit(newPrintThread::printB);
            executorService.submit(newPrintThread::printC).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
