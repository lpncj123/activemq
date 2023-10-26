package cn.lp.leetcode;

import java.util.Arrays;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-04  15:00
 * @Description: TODO
 * @Version: 1.0
 */
public class Qusetion16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = 0, n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int x = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int s = x + nums[i + 1] + nums[i + 2];
            if (s > target) {
                if (s - target < minDiff) {
                    ans = s;
                }
                break;
            }
            s = x + nums[n - 2] + nums[n - 1];
            if (s < target) {
                if (target - s < minDiff) {
                    minDiff = target - s;
                    ans = s;
                }
                continue;
            }
            int j = i + 1, k = n - 1;
            while (j < k) {
                s = x + nums[j] + nums[k];
                if (s == target) {
                    return s;
                } else if (s < target) {
                    if (target - s < minDiff) {
                        minDiff = target - s;
                        ans = s;
                    }
                    j++;
                } else {
                    if (s - target < minDiff) {
                        minDiff = s - target;
                        ans = s;
                    }
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        System.out.println(new Qusetion16().threeSumClosest(arr, 1));
    }
}
