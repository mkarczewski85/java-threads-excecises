package threading.producer_consumer;

import lombok.Getter;

public class Consumer implements Runnable {

    private static final long DEFAULT_DELAY = 100;
    private final Producer producer;
    private final String name;
    @Getter
    private int messageCount = 0;

    public Consumer(Producer producer, String name) {
        this.producer = producer;
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String message = producer.getMessage();
                if (message != null) {
                    System.out.println("Received message: " + message);
                } else {
                    System.out.println("Failed to receive message!");
                }
                Thread.sleep(DEFAULT_DELAY);
            } catch (InterruptedException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
