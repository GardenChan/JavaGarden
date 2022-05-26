package dream.high_frequency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 20:42
 * author: Jiading chen
 * description: NC46 加起来和为目标值的组合
 * 输入：[100,10,20,70,60,10,50],80
 * 返回值：[[10,10,60],[10,20,50],[10,70],[20,60]]
 * 说明：给定的候选数集是[100,10,20,70,60,10,50]，目标数是80
 * @回溯法
 */
public class AddTargetCombination {
    public ArrayList<ArrayList<Integer>> combinationSum2(int[] num, int target) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        if(num == null || num.length==0 || target<0)return res;
        Arrays.sort(num);
        dfs(num,target,res,arr,0);
        return res;
    }
    void dfs(int[] num,int target,ArrayList<ArrayList<Integer>> res,ArrayList<Integer> arr,int start){
        if(target==0){
            res.add(new ArrayList<Integer>(arr));
            return;
        }
        if(start >= num.length)return;
        for(int i=start;i<num.length;i++){
            if(i > start && num[i] == num[i-1])continue;
            if(num[i] <= target){
                arr.add(num[i]);
                dfs(num,target-num[i],res,arr,i+1);
                arr.remove(arr.size()-1);
            }
        }
        return;
    }
}
