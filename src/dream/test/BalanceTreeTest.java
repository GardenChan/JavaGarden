package dream.test;

import dream.common.TreeNode;

/**
 * projectName:java-garden
 * see:dream.test
 * createTime:2021/9/4 23:48
 * author: Garden Chan
 * description: 平衡树
 */
public class BalanceTreeTest {
    public boolean isBalancedTree(TreeNode root){
        if (root==null) return true;
        return Math.abs(heightOfTree(root.right) - heightOfTree(root.left))<=1 && isBalancedTree(root.left) && isBalancedTree(root.right);
    }
    private int heightOfTree(TreeNode root){
        if (root==null) return 0;
        return Math.max(heightOfTree(root.left), heightOfTree(root.right)) + 1;
    }
}
