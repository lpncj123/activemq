package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2024-02-02  16:32
 * @Description: TODO
 * @Version: 1.0
 */
public class Question34self {
    public static int[] searchRange(int[] nums, int target) {
        int first = -1;
        int last = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left+right)/2;
            if(nums[mid]==target){
                first = mid;
                right = mid -1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }

        left = 0;
        right = nums.length-1;
        while (left <= right) {
            int mid = (left+right)/2;
            if(nums[mid]==target){
                last = mid;
                left = mid +1;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return new int[]{first, last};
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,3,3,3,4,5,9};
        for (int i : Question34self.searchRange(arr, 3)) {
            System.out.println(i);
        }
    }
}
