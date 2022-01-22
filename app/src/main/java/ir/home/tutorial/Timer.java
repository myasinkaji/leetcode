package ir.home.tutorial;


import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Timer {
    private static Map<Thread, Timer> timers = new HashMap<>();
    private long start;
    private long end;
    private final String name;

    private Timer(String name) {
        this.name = name;
    }

    public void sleepPrintLess(float seconds) {
        try {
            Thread.sleep((long) (seconds * 1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void sleep(int seconds) {
        System.out.println("[" + LocalDateTime.now() + "]    " + name + " -- " + Thread.currentThread().getName() + "'s is going to sleep");
        sleepPrintLess(seconds);
        System.out.println("[" + LocalDateTime.now() + "]    " + name + " -- " + Thread.currentThread().getName() + "'s sleep time is elapsed");
    }

    public static Timer get() {
        return timers.computeIfAbsent(Thread.currentThread(), t -> timers.put(t, newTimer(t.getName())));
    }
    public static Timer newTimer(String name) {
        timers.put(Thread.currentThread(), new Timer(name));
        return timers.get(Thread.currentThread());
    }

    public Timer takeTime() {
        start = System.currentTimeMillis();
        System.out.println(name + " is started...");
        return this;
    }

    public Timer finish() {
        end = System.currentTimeMillis();
        return this;
    }

    public void printTime() {
        System.out.println("Elapsed time: " + ((end - start) / 1000d));
    }

}
