package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/3 1:31
 * author: Garden Chan
 * description: LeetCode 55 跳跃游戏
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int end = len - 1;
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] >= end - i) {
                end = i;
            }
        }
        return end == 0;
    }
}
