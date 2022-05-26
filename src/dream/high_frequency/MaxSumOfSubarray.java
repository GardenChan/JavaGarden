package dream.high_frequency;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/9 1:25
 * author: Garden Chan
 * description: NC19 子数组的最大累加和问题
 */
public class MaxSumOfSubarray {
    /**
     * max sum of the subarray
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxSumOfSubarray (int[] arr) {
        // write code here
        int pre = 0;
        int maxSum = arr[0];
        for (int i : arr) {
            pre = Math.max(pre + i, i);
            maxSum = Math.max(pre, maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        MaxSumOfSubarray subarray = new MaxSumOfSubarray();
        int[] input = {1, -2, 3, 5, -2, 6, -1};
        int i = subarray.maxSumOfSubarray(input);
        System.out.println(i);
    }
}
