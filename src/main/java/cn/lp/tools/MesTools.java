package cn.lp.tools;

import java.util.Random;

/**
 * @program: chinagpaywork
 * @description: mes工具类
 * @author: JianJun.Qu
 * @create: 2021-03-05 23:22
 **/
public class MesTools {
    public static String getRandomDigital(int n)
    {
        int array[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for(int i = 10; i > 1; i--)
        {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++)
        {
            sb.append(array[i]);

        }
        return sb.toString();
    }
}
