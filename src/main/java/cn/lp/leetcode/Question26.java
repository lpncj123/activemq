package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-29  18:11
 * @Description: TODO
 * @Version: 1.0
 */
public class Question26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length==0){
            return 0;
        }
        int fast =1;
        int slow =1;
        while(fast<length){
            if(nums[fast]!=nums[fast-1]){
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }

    public static void main(String[] args) {
        int [] arr = {1,1,2,3};
        System.out.println(new Question26().removeDuplicates(arr));
    }
}
