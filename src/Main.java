import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //通过多线程编程，来模拟一个餐厅的2个厨师和3个顾客，假设厨师炒出一个菜的时间为3秒，顾客吃掉菜品的时间为4秒，窗口上只能放一个菜。
        //通过阻塞队列实现生产者消费者模式
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(1);
        //生产者
        Runnable supplier = () -> {
            while(true){
                try{
                    String name = Thread.currentThread().getName();
                    System.err.println(time() + "生产者" + name + " 正在准备餐品...");
                    TimeUnit.SECONDS.sleep(3);
                    System.err.println(time() + "生产者" + name + " 已经出餐");
                    queue.put(new Object());
                }catch (InterruptedException e){
                    e.printStackTrace();
                    break;
                }
            }
        };
        Runnable consumer = () -> {
            while (true){
                try {
                    String name = Thread.currentThread().getName();
                    System.out.println(time()+"消费者 "+name+" 正在等待出餐...");
                    queue.take();
                    System.out.println(time()+"消费者 "+name+" 取到了餐品。");
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(time()+"消费者 "+name+" 已经将饭菜吃完了！");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
        };
        for(int i=0;i<2;i++){
            new Thread(supplier,"厨师" + i).start();
        }
        for(int i=0;i<3;i++){
            new Thread(consumer,"顾客" + i).start();
        }
    }

    public static String time(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        return "[" + format.format(new Date()) + "]";
    }
}