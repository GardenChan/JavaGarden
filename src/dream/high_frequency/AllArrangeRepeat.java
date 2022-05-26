package dream.high_frequency;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance.tree
 * createTime:2021/9/8 20:38
 * author: Jiading chen
 * description: NC42 有重复项数字的所有排列
 * Boolean+数组记录
 */
public class AllArrangeRepeat {
    public ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if(num == null || num.length == 0){
            return rst;
        }
        Arrays.sort(num);
        boolean[] visit = new boolean[num.length];
        ArrayList<Integer> list = new ArrayList<>();
        fun(rst,list,visit,num);
        return rst;
    }

    public void fun(ArrayList<ArrayList<Integer>> rst,ArrayList<Integer> list,boolean[] visit,int[] num){
        if(list.size() == num.length){
            rst.add(new ArrayList<Integer>(list));
        }
        for(int i = 0;i<num.length ;i++){
            if(visit[i] == true || (i!=0&&num[i] == num[i-1] )&&visit[i-1] == false){
                continue;
            }
            visit[i] = true;
            list.add(num[i]);
            fun(rst,list,visit,num);
            list.remove(list.size()-1);
            visit[i] = false;
        }
    }
}
