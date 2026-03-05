import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //线程安全的并发容器
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            new Thread(() -> {
                for (int j = 0; j < 100; j++)
                    list.add("lbwnb");
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println(list.size());
        System.out.println(list.toString());
    }
}