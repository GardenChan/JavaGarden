package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/2 23:34
 * author: Jiading chen
 * description: LeetCode 42 接雨水
 */
public class MaxRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n==0 || n==1) return 0;
        int[] leftMax = new int[n];
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];
        for (int i = n-2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;
        for (int i = n-1; i >= 0; i--) {
            water += Math.min(leftMax[i], rightMax[i])-height[i];
        }
        return water;
    }
}
