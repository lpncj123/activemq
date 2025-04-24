package cn.lp;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp
 * @Author: lp
 * @CreateTime: 2024-04-10  15:17
 * @Description: TODO
 * @Version: 1.0
 */
public class InternTest {
    public static void main(String[] args) {
        String s1 = new String("a");
        String intern = s1.intern();
        String s2 = "a";
        System.out.println(s1==s2);
        System.out.println(s2==intern);

        String s3 = new String("a")+new String("a");
        s3.intern();
        String s4 = "aa";
        System.out.println(s3==s4);
    }

}
