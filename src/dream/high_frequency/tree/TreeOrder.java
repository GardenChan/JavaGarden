package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 18:11
 * author: Jiading chen
 * description: NC45 实现二叉树先序，中序和后序遍历
 */
public class TreeOrder {
    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] res = new int[3][];
        res[0] = preOrder(root);
        res[1] = midOrder(root);
        res[2] = postOrder(root);
        return res;
    }

    private int[] preOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preOrder(root,list);
        return arrayListToArray(list);
    }

    private void preOrder(TreeNode root,List<Integer> list){
        if(root==null) return;
        list.add(root.val);
        preOrder(root.left,list);
        preOrder(root.right,list);
    }

    private int[] midOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        midOrder(root,list);
        return arrayListToArray(list);
    }

    private void midOrder(TreeNode root,List<Integer> list){
        if(root==null) return;
        midOrder(root.left,list);
        list.add(root.val);
        midOrder(root.right,list);
    }

    private int[] postOrder(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postOrder(root,list);
        return arrayListToArray(list);
    }

    private void postOrder(TreeNode root, List<Integer> list){
        if(root==null) return;
        postOrder(root.left,list);
        postOrder(root.right,list);
        list.add(root.val);
    }

    private int[] arrayListToArray(List<Integer> list){
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
