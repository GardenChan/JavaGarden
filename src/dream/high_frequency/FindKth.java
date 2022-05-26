package dream.high_frequency;

import java.util.Arrays;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/3 0:35
 * author: Garden Chan
 * description: NC88 寻找第K大
 * leetcode https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class FindKth {
    public int findKth(int[] a, int n, int K) {
        // write code here
        Arrays.sort(a);
        return a[n - K];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
