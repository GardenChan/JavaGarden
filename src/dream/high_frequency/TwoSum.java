package dream.high_frequency;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/8 23:49
 * author: Garden Chan
 * description: NC61 两数之和
 */
public class TwoSum {
    /**
     * 使用 HashMap
     * @param numbers int整型一维数组
     * @param target int整型
     * @return int整型一维数组
     */
    public int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])){
                result[0] = map.get(numbers[i]);
                result[1] = i+1;
            }else {
                map.put(target - numbers[i], i+1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] input = {3, 2, 4};
        int target = 6;
        TwoSum twoSum = new TwoSum();
        int[] ints = twoSum.twoSum(input, target);
        System.out.println(Arrays.toString(ints));

    }
}
