package simple_thread;

import lombok.Getter;

public class Counter {

    @Getter
    private volatile long value = 0;

    public synchronized void add(int x){
        value += x;
    }

}
