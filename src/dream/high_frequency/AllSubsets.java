package dream.high_frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/7 23:48
 * author: Garden Chan
 * description: NC27 集合的所有子集
 */
public class AllSubsets {
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        int num = length == 0 ? 0 : 1 << length;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0;i < num;i++){
            List<Integer> tmp = new ArrayList<>();
            int index = i;
            for (int j = 0;j < length;j++){
                if ((index & 1) == 1){
                    tmp.add(nums[j]);
                }
                index >>= 1;
            }
            res.add(tmp);
        }
        return res;
    }


    public static void main(String[] args) {
        AllSubsets allSubsets = new AllSubsets();
        List<List<Integer>> subsets = allSubsets.subsets(new int[]{1, 2, 3, 4});
        System.out.println(subsets);
        System.out.println(subsets.size());
    }
}
