package cn.lp.leetcode;

/**
 * @BelongsProject: activemq
 * @BelongsPackage: cn.lp.leetcode
 * @Author: lp
 * @CreateTime: 2023-08-03  17:20
 * @Description: TODO
 * @Version: 1.0
 */
public class Question11 {
    public static int maxArea(int[] height) {
        int l = 0,r = height.length-1;
        int ans = 0;
        while(l<r){
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans,area);
            if(height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] myArray = {1,8,6,2,5,4,8,3,7};
        int i = Question11.maxArea(myArray);
        System.out.println(i);
    }
}
