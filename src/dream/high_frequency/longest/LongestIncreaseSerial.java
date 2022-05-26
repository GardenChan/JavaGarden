package dream.high_frequency.longest;

import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance.longest
 * createTime:2021/9/8 18:12
 * author: Jiading chen
 * description: NC91 最长递增子序列
 * @复杂度太大 数据量大的时候超时
 */
public class LongestIncreaseSerial {
    /**
     * retrun the longest increasing subsequence
     * @param arr int整型一维数组 the array
     * @return int整型一维数组
     */
    public int[] LIS (int[] arr) {
        // write code here
        // 先求最长递增子序列的长度
        int maxLength = 0;
        int[] dp = new int[arr.length];
        dp[0] = 1;
        int totalMax = 1;
        for (int i = 1; i < arr.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i]>arr[j]){
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
            totalMax = Math.max(max, totalMax);
        }
        System.out.println(totalMax);
        int[] res = new int[totalMax];
        int index = totalMax - 1;
        for (int i = dp.length - 1; i >= 0; i--) {
            if (dp[i] == totalMax) {
                res[index] = arr[i];
                index--;
                totalMax--;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {2, 1, 5, 3, 6, 4, 8, 9, 7};
        LongestIncreaseSerial longestIncreaseSerial = new LongestIncreaseSerial();
        int[] lis = longestIncreaseSerial.LIS(input);
        System.out.println(Arrays.toString(lis));
    }
}
