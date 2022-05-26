package dream.high_frequency;

import java.util.LinkedList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.high_frequency
 * createTime:2021/11/10 2:10
 * author: Garden Chan
 * description: LeetCode 442. 数组中重复的数据
 */
public class ArrayFindDuplicate {
    public List<Integer> findDuplicates(int[] nums) {
        int l = nums.length;
        for (int i:nums){
            int j = (i-1) % l;
            nums[j] += l;
        }
        List<Integer> ret = new LinkedList<Integer>();
        for (int i = 0; i < l; i++) {
            if (nums[i]>2*l){
                ret.add(i+1);
            }
        }
        return ret;

    }
}
