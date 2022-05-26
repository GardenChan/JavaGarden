package dream.high_frequency.longest;

/**
 * projectName:java-garden
 * see:dream.bytedance.longest
 * createTime:2021/9/8 18:24
 * author: Jiading chen
 * description: LeetCode 674. 最长连续递增序列 的长度
 * @simple
 */
public class LongestContinuousIncreaseSerialLength {
    public int findLengthOfLCIS(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int cmp = nums[i];
            int count = 1;
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[j] > cmp) {
                    count++;
                    cmp = nums[j];
                }else {
                    break;
                }
            }
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestContinuousIncreaseSerialLength serialLength = new LongestContinuousIncreaseSerialLength();
        int lengthOfLCIS = serialLength.findLengthOfLCIS(new int[]{1, 3, 5, 7});
        System.out.println(lengthOfLCIS);
    }
}
