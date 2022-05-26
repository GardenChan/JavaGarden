package dream.high_frequency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/1 23:37
 * author: Garden Chan
 * description: NC119 最小的K个数
 */
public class KLeastNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        Arrays.sort(input);
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input = {4,5,1,6,2,7,3,8};
        KLeastNumber kLeastNumber = new KLeastNumber();
        ArrayList<Integer> integers = kLeastNumber.GetLeastNumbers_Solution(input, 4);
        System.out.println(integers);
    }
}
