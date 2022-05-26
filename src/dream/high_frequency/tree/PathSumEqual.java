package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayList;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/23 23:27
 * author: Garden Chan
 * description: NC8 二叉树根节点到叶子节点和为指定值的所有路径
 */
public class PathSumEqual {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        allPathEqual(root, new ArrayList<Integer>(), sum, ansList);
        return ansList;
    }

    private void allPathEqual(TreeNode root, ArrayList<Integer> arrayList, int sum, ArrayList<ArrayList<Integer>> ansList) {
        if (root!=null){
            ArrayList<Integer> list = new ArrayList<>(arrayList);
            list.add(root.val);
            if (root.left == null && root.right == null && sumOfList(list) == sum) {
                ansList.add(list);
            }else {
                allPathEqual(root.left, list, sum, ansList);
                allPathEqual(root.right, list, sum, ansList);
            }
        }
    }

    private int sumOfList(ArrayList<Integer> arrayList){
        int sum = 0;
        for (Integer integer : arrayList) {
            sum += integer;
        }
        return sum;
    }
}
