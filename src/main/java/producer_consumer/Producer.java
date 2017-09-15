package producer_consumer;


import lombok.Getter;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Queue;

public class Producer implements Runnable {

    private static final int MAX_QUEUE = 5;
    private static final int DEFAULT_DELAY = 100;
    private final Queue<String> messages = new LinkedList<>();
    @Getter
    private int messageCount = 0;
    private final SecureRandom secureRandom = new SecureRandom();

    @Override
    public void run() {
        while (true) {
            try {
                putMessage();
                System.out.println("Message sent!");
                messageCount++;
                Thread.sleep(DEFAULT_DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void putMessage() throws InterruptedException {
        while (messages.size() >= MAX_QUEUE) {
            Thread.sleep(100);
        }
        messages.add(new BigInteger(130, secureRandom).toString());
    }

    public String getMessage() throws InterruptedException {
        while (messages.isEmpty()) {
            Thread.sleep(DEFAULT_DELAY);
        }
        return messages.poll();
    }

}
