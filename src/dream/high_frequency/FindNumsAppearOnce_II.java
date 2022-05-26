package dream.high_frequency;

import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 11:13
 * author: Jiading chen
 * description: NC75 数组中只出现一次的两个数字
 */
public class FindNumsAppearOnce_II {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * @param array int整型一维数组
     * @return int整型一维数组
     */
    public int[] FindNumsAppearOnce (int[] array) {
        // write code here
        int temp = 0;
        for (int i : array) {
            temp ^= i;
        }
        int flag = 1;
        while ((temp & flag) == 0) {
            flag <<= 1;
        }

        int[] res = new int[2];
        for (int item : array) {
            if ((item & flag) == 0) {
                res[0] ^= item;
            }else {
                res[1] ^= item;
            }
        }
        Arrays.sort(res);
        return res;
    }
}
