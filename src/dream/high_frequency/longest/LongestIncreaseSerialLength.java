package dream.high_frequency.longest;

/**
 * projectName:java-garden
 * see:dream.bytedance.longest
 * createTime:2021/9/8 18:18
 * author: Jiading chen
 * description: LeetCode 300. 最长递增子序列
 *
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。
 * 例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LongestIncreaseSerialLength {
    public int lengthOfLIS(int[] nums){
        if (nums.length==0) return 0;
        int[] record = new int[nums.length];
        record[0] = 1;
        int totalMax = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (record[j]+1>max) max = record[j] + 1;
                }
            }
            record[i] = max;
            if (max>totalMax) totalMax = max;
        }
        return totalMax;
    }
}
