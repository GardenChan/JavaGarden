package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:java-garden
 * see:dream.bytedance.tree
 * createTime:2021/9/8 21:25
 * author: Jiading chen
 * description: NC6 二叉树的最大路径和
 */
// @TODO
public class TreeMaxPathSum {
    int maxValue = Integer.MIN_VALUE;
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int help(TreeNode root){
        if(root == null)return 0;
        int left = help(root.left);
        int right = help(root.right);
        maxValue = Math.max(maxValue, Math.max(0,left) + root.val +  Math.max(0,right));
        return Math.max( Math.max(0,left) + root.val, Math.max(0,right)+root.val);
    }

    public int maxPathSum(TreeNode root) {

        if(root == null)return 0;
        //if(root.left == null && root.right == null)
        help(root);
        return maxValue;
    }
}
