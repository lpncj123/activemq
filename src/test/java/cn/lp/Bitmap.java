package cn.lp;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-07-15  17:44
 * @Description: TODO
 * @Version: 1.0
 */
public class Bitmap {
    // 位图存储数组，每个int存储32个位
    private int[] bitmap;

    // 初始化位图
    public Bitmap(int size) {
//        每个 int 类型变量有 32 位：由于 int 类型在 Java 中占用 4 个字节（32 位），我们可以使用一个 int 类型变量存储 32 个整数的存在信息。
//        所以就可以缩小位图减少长度，因为位图是每一位代表一个数字，一个int类型4字节可以代表32个数字

        // 创建一个足够大的位图数组，位图大小为 (size / 32) + 1
        bitmap = new int[(size >> 5) + 1];
    }

    // 设置位，将整数 n 存入位图中
    public void set(int n) {
        int index = n >> 5;   // 整数 n 在数组中的位置   这个得到放入数组的哪个位置中
        int position = n & 0x1F;  // 整数 n 在 32 位中的具体位置，相当于 n % 32 。n在int32位中的位置
        bitmap[index] |= 1 << position; //在第几位就向左移动几位，然后与当前int进行或操作，把int32中的位置设置为1
    }

    // 判断位，判断整数 n 是否在位图中
    public boolean get(int n) {
        int index = n >> 5;
        int position = n & 0x1F;
        return (bitmap[index] & (1 << position)) != 0;
    }

    public static void main(String[] args) {
        // 范围 1 - 2 亿
        int size = 200000000;
        Bitmap bm = new Bitmap(size);

        // 插入一些整数
        bm.set(100);
        bm.set(200000000);
        bm.set(199999999);

        // 判断整数是否存在
        System.out.println(bm.get(100));         // true
        System.out.println(bm.get(200000000));   // true
        System.out.println(bm.get(199999999));   // true
        System.out.println(bm.get(500));         // false
    }
}

