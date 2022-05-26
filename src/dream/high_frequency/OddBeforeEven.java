package dream.high_frequency;

import java.util.Arrays;
import java.util.Comparator;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 2:12
 * author: Garden Chan
 * description: NC77 调整数组顺序使奇数位于偶数前面
 */
public class OddBeforeEven {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] reOrderArray (int[] array) {
        // write code here
        int[][] numsToIndex = new int[array.length][2];
        for (int i = 0; i < array.length; i++) {
            numsToIndex[i][0] = array[i];
            numsToIndex[i][1] = i;
        }
        Arrays.sort(numsToIndex,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                // 都是奇数
                if (o1[0] % 2 == 1 && o2[0] % 2 == 1) {
                    return o1[1] - o2[1];
                }// 都是偶数
                else if (o1[0] % 2 == 0 && o2[0] % 2 == 0) {
                    return o1[1] - o2[1];
                }// 一奇一偶
                else if (o1[0] % 2 == 1 && o2[0] % 2 == 0) {
                    return -1;
                }// 一偶一奇数
                else {
                    return 1;
                }
            }
        });

        for (int i = 0; i < numsToIndex.length; i++) {
            array[i] = numsToIndex[i][0];
        }
        return array;
    }

    public static void main(String[] args) {
        OddBeforeEven oddBeforeEven = new OddBeforeEven();
        int[] ints = oddBeforeEven.reOrderArray(new int[]{1,2,3});
        System.out.println(Arrays.toString(ints));
    }
}
