class Counter {
    private int counter = 0;

    // Synchronized method to ensure thread-safe increment
    public synchronized void increment() {
        counter++;
    }

    public int getValue() {
        return counter;
    }
}

public class ex_3 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Final counter value: " + counter.getValue());
    }
}
