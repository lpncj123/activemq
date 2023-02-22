package cn.lp.leetcode;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-02-22  10:10
 * @Description: TODO
 * @Version: 1.0
 */
public class Solution {
    //取中序数
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = IntStream.concat(Arrays.stream(nums1), Arrays.stream(nums2)).toArray();
        int length = nums3.length;
        Arrays.sort(nums3);
        if (length % 2 != 0) {
            int i = (int) Math.floor(length / 2);
            return nums3[i];
        }else{
            int i1 = nums3[length/2-1] + nums3[length/2];
            double round = (double) i1/2;
            return round;
        }
    }
//    public String convert(String s, int numRows) {
//         String s = "";
//    }
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
//        int[] num1 = {1, 2,99,5};
//        int[] num2 = {3,4};
//        double medianSortedArrays = new Solution().findMedianSortedArrays(num1, num2);
//        System.out.println(medianSortedArrays);
    }
    public int maxArea(int[] height) {
        Arrays.sort(height);
        int i = height[height.length - 2];
        return i*i;
    }
}
