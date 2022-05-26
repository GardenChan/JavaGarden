package dream.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.test
 * createTime:2021/9/4 23:27
 * author: Garden Chan
 * description: 全排列
 */
public class AllArrange {
    public List<List<Integer>> permute(int[] nums){
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length==0){
            return res;
        }
        ArrayDeque<Integer> path = new ArrayDeque<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, 0, path, visited, res);
        return res;
    }

    private void dfs(int[] nums, int depth, ArrayDeque<Integer> path, boolean[] visited, List<List<Integer>> res) {
        if (nums.length==path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            path.push(nums[i]);
            visited[i] = true;
            dfs(nums, depth + 1, path, visited, res);
            path.pop();
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        AllArrange allArrange = new AllArrange();
        System.out.println("begin..");
        List<List<Integer>> permute = allArrange.permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
