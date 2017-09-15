package threading.async;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ArrayAsyncSearch {

    private double[] arr;
    private final int THREADS_COUNT;
    private Thread[] threads;
    private double smallest;
    private Lock locker = new ReentrantLock();


    public ArrayAsyncSearch(double[] arr, int numberOfThreads) {
        this.arr = arr;
        this.THREADS_COUNT = numberOfThreads;
        this.threads = new Thread[numberOfThreads];
        this.smallest = arr[0];
    }


    public double startComputation() throws InterruptedException {

        for (int i = 0; i < threads.length; i++) {
            int helper = i;
            threads[i] = new Thread(() -> {
                methodForThread(helper);
            });
            threads[i].start();
            threads[i].join();
        }

        return smallest;
    }

    private void methodForThread(int startindex) {

        double min = arr[startindex];
        for (int i = startindex; i < arr.length; i += THREADS_COUNT) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }

        locker.lock();
        try {
            if (min < smallest) {
                smallest = min;
            }
        } finally {
            locker.unlock();
        }

    }

}
