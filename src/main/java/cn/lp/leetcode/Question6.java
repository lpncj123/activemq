package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-03  13:59
 * @Description: TODO
 * @Version: 1.0
 */
public class Question6 {
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String result = convert(s, numRows);
        System.out.println(result);
    }
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
//step=1是向上，等于-1是向下
        int index = 0, step = 1;
        for (char c : s.toCharArray()) {
            rows[index].append(c);
            if (index == 0) {
                step = 1;
                //如果是最后一行
            } else if (index == numRows - 1) {
                step = -1;
            }
            index += step;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}

