package dream.high_frequency.longest;

import java.util.LinkedList;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/9 1:36
 * author: Garden Chan
 * description: NC41 最长无重复子数组
 */
public class LongestRepetitionMaxLength {
    /**
     * 使用队列
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxLength (int[] arr) {
        // write code here
        int maxLen = 0;
        LinkedList<Integer> queue = new LinkedList<>();
        for (int value : arr) {
            if (queue.contains(value)) {
                maxLen = Math.max(maxLen, queue.size());
            }
            while (queue.contains(value)) {
                queue.poll();
            }
            queue.add(value);
        }
        return Math.max(maxLen, queue.size());
    }

    public static void main(String[] args) {
        LongestRepetitionMaxLength maxLength = new LongestRepetitionMaxLength();
        int[] input = {2};
        int i = maxLength.maxLength(input);
        System.out.println(i);
    }
}
