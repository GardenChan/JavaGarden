package dream.high_frequency;

import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 10:53
 * author: Jiading chen
 * description: NC130 分糖果问题
 */
public class Candy {
    /**
     * pick candy
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int candy (int[] arr) {
        // write code here
        int[] candies = new int[arr.length];
        Arrays.fill(candies, 1);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i-1]+1;
            }
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }
        int sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        return sum;
    }
}
