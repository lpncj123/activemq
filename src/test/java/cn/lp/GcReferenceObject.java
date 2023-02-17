package cn.lp;

public class GcReferenceObject {
    private static Object ref;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        // 创建一个新对象并赋值给静态变量ref
        ref = new Object();
    }

    public static void main(String[] args) {
        /**
         * 可能是因为 finalize() 方法是在 GC 线程中执行的，而在 GC 线程执行 finalize() 方法之前，对象引用已经被置为了 null，所以在 finalize() 方法中获取对象引用的值为 null。
         *
         * 另外，Java 中的垃圾回收器是不保证对象的 finalize() 方法会被及时执行的，因此在实际开发中，不应该过度依赖 finalize() 方法。
         */
        GcReferenceObject obj = new GcReferenceObject();
        obj = null; // 将obj设置为null，使其成为垃圾
        System.gc(); // 强制进行一次垃圾回收
        System.out.println(ref); // 输出引用对象
    }
}
