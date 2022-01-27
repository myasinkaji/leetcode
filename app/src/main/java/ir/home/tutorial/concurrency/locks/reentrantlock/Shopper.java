package ir.home.tutorial.concurrency.locks.reentrantlock;

import ir.home.tutorial.Timer;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Shopper extends Thread {
    private static AtomicInteger garlicCount = new AtomicInteger();
    private static AtomicInteger potatoCount = new AtomicInteger();

    private static final Lock pencil = new ReentrantLock();

    private void addGarlic() {
        pencil.lock();
        garlicCount.incrementAndGet();
        pencil.unlock();
    }

    private void addPotato() {
        pencil.tryLock();
        potatoCount.incrementAndGet();
        pencil.unlock();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10_000; i++) {
            addGarlic();
            addPotato();
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Timer.get().takeTime();
        final var mohammadYasin = new Shopper();
        final var zahra = new Shopper();
        mohammadYasin.start();
        zahra.start();
        mohammadYasin.join();
        zahra.join();
//        Timer.get().finish().printTime();

        System.out.printf("End...\n Garlic Count: %s, Potato Count: %s%n",
                mohammadYasin.garlicCount, mohammadYasin.potatoCount);
    }
}
