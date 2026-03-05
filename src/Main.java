import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lock testLock = new ReentrantLock();
        Lock test02 = new ReentrantLock();
        new Thread(() -> {
            testLock.lock();
            try {
                System.out.println("等待是否未超时："+testLock.newCondition().await(1, TimeUnit.SECONDS));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            testLock.unlock();
        }).start();

        System.out.println("60秒 = "+TimeUnit.SECONDS.toMinutes(60) +"分钟");
        System.out.println("365天 = "+TimeUnit.DAYS.toSeconds(365) +" 秒");
    }
}