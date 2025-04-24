package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-01-30  17:47
 * @Description: TODO
 * @Version: 1.0
 */
public class Qusetion31self {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //从后往前找到比后一位小的数字
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
//            找比数组i位置上大的一位数字，从后往前找，然后交换位置
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            swap(nums, i, j);
        }
//        交换位置之后排序i后面位置数组，及得到最小的排列数
        reverse(nums,i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length-1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}





