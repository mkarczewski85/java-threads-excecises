package async;

import java.util.Random;

public class ArrayAsyncProgram {

    public static double sumArray(double[] arr){
        double sum = 0;

        for (double e : arr){
            sum += e;
        }

        return sum;
    }

    public static void main(String[] args) throws InterruptedException {

        int ARRAY_SIZE = 1000000;

        double[] arr = new double[ARRAY_SIZE];

        Random random = new Random();

        for (int i = 0; i < arr.length; i++){
            arr[i] = random.nextDouble();
        }

        long start1 = System.currentTimeMillis();
        ArrayAsync async = new ArrayAsync(arr, 4);
        double v4 = async.startCalculations();
        long end1 = System.currentTimeMillis() - start1;
        System.out.println("Wynik dla czterech wątków: " + v4 + " czas: " + end1);

        long start2 = System.currentTimeMillis();
        double v1 = sumArray(arr);
        long end2 = System.currentTimeMillis() - start2;
        System.out.println("Wynik dla jednego wątku: " + v1 + " czas: " + end2);
    }

}
