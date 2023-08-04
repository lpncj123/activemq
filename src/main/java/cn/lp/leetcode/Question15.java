package cn.lp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-04  10:24
 * @Description: TODO
 * @Version: 1.0
 */
public class Question15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n - 2; ++i) {
            int x = nums[i];
            if (i > 0 && x == nums[i - 1]) {
                continue;
            }
            if ((x + nums[i + 1] + nums[i + 2]) > 0) {
                break;
            }
            if ((x + nums[n - 1] + nums[n - 2]) < 0) {
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                int s = x + nums[j] + nums[k];
                if (s > 0) {
                    --k; // 向前移动 k
                } else if (s < 0) {
                    ++j; // 向后移动 j
                } else {
                    list.add(Arrays.asList(x, nums[j], nums[k]));
                    ++j; // 向后移动 j
                    --k; // 向前移动 k
                    while (j < k && nums[j] == nums[j - 1]) {
                        ++j; // 跳过重复数字
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        --k;
                    }

                }


            }
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Question15().threeSum(arr));
    }
}
