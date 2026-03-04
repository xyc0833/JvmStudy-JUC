import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Main {
    public static void main(String[] args) {
        SoftReference<Object> softReference = new SoftReference<>(new Object());
        WeakReference<Object> weakReference = new WeakReference<>(new Object());

        //手动GC
        System.gc();

        System.out.println("软引用对象："+softReference.get());
        System.out.println("弱引用对象："+weakReference.get());
    }
}