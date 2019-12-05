package de.telran;

public class ThreadWithRunnableInterface implements Runnable {
    Counter counter;

    public ThreadWithRunnableInterface(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for (int i = 1000; i > 0; i--) {
            counter.decrement();
        }
    }

    public int getCounter() {
        return counter.getValue();
    }
}
