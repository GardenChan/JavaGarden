package dream.high_frequency;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/3 0:48
 * author: Garden Chan
 * description: LeetCode 15 三数之和为0
 */
public class ThreeNumberSumOfZero {
    public List<List<Integer>> threeSum(int[] nums) {
        int len = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        if (nums==null||len < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len; i++) {
            if (nums[i]>0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum==0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L<R&&nums[L+1]==nums[L]) L++;
                    while (L<R&&nums[R]==nums[R-1]) R--;
                    L++;
                    R--;
                }
                else if (sum<0) L++;
                else if (sum>0) R--;
            }
        }
        return ans;
    }
}
