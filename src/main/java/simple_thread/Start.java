package simple_thread;

public class Start {

//    static class Task implements Runnable{
//
//        @Override
//        public void run() {
//            System.out.println("Proces in separate thread");
//        }
//    }

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Works: ");

        Thread t1 = new Thread(new Countdown("Thread1", 50));
        Thread t2 = new Thread(new Countdown("Thread2", 50));
        Thread t3 = new Thread(new Countdown("Thread3", 50));
        t1.start();
        t2.start();
        t3.start();
//        t1.join();
//        t2.join();
//        t3.join();


        System.out.println("End of threads");




    }

}
