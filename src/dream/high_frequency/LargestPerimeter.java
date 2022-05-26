package dream.high_frequency;

import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/3 1:44
 * author: Garden Chan
 * description: LeetCode 976. 三角形的最大周长
 */
public class LargestPerimeter {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i] + nums[i - 1] + nums[i - 2];
            }
        }
        return 0;
    }
}
