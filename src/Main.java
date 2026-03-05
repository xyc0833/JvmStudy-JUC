import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger integer = new AtomicInteger(1);
        System.out.println(integer.compareAndSet(1,2));
        System.out.println(integer.compareAndSet(3,2));
    }
}