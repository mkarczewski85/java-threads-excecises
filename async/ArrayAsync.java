package threading.async;

public class ArrayAsync {

    private double[] arr;
    private int THREADS_COUNT;
    private Thread[] threads;
    private double sum;
    private final Object locker = new Object();

    public ArrayAsync(double[] arr, int THREADS_COUNT) {
        this.arr = arr;
        this.THREADS_COUNT = THREADS_COUNT;
        this.threads = new Thread[THREADS_COUNT];
    }

    public double startCalculations() throws InterruptedException {
        for (int i = 0; i < threads.length; i++) {
            int helper = i;
            threads[i] = new Thread(() -> {
                singleThreadTask(helper);
            });
            threads[i].start();
            threads[i].join();
        }
        return sum;
    }


    private void singleThreadTask(int startindex) {
        double result = 0;
        for (int i = startindex; i < arr.length; i += THREADS_COUNT) {
            result += arr[i];
        }

        synchronized (locker) {
            sum += result;
        }

    }


}
