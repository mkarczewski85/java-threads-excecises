package threading.simple_thread;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Countdown implements Runnable {

    private String name;
    private int limit;


    @Override
    public void run() {
        for (int i = limit; i >= 1; i--){
            try {
                System.out.println(name + " " + i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
