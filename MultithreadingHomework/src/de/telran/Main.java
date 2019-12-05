package de.telran;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        ThreadWithThreadClass thread1 = new ThreadWithThreadClass(counter);
        thread1.start();
        thread1.join();
        System.out.println(thread1.getCounter());

        ThreadWithRunnableInterface thread2 = new ThreadWithRunnableInterface(counter);
        Thread t = new Thread(thread2);
        t.start();
        t.join();
        System.out.println(thread2.getCounter());
    }
}
