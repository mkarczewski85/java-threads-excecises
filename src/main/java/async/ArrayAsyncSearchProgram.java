package async;

import java.util.Random;

public class ArrayAsyncSearchProgram {

    public static double singleThread(double[] arr){
        double min = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }

    public static void main(String[] args) throws InterruptedException {

        int ARRAY_SIZE = 1000000;

        double[] arr = new double[ARRAY_SIZE];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextDouble();
        }

        long start1 = System.currentTimeMillis();
        ArrayAsyncSearch arrayAsyncSearch = new ArrayAsyncSearch(arr, 4);
        double value1 = arrayAsyncSearch.startComputation();
        long end1 = System.currentTimeMillis() - start1;
        System.out.println("4 threads result: " + value1 + " time: " + end1);

        long start2 = System.currentTimeMillis();
        double value2 = singleThread(arr);
        long end2 = System.currentTimeMillis() - start2;
        System.out.println("1 threads result: " + value2 + " time: " + end2);

        Object o = new Object();
        o.notify();


    }

}
