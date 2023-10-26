package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-03  17:42
 * @Description: TODO
 * @Version: 1.0
 */
public class Question12 {
    public static String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            int value = values[i];
            String symbol = symbols[i];
            while(num>=value){
                stringBuffer.append(symbol);
                num-=value;
                if(num<value){
                    break;
                }
            }
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        System.out.println(Question12.intToRoman(3999));
    }
}
