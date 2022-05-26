package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 1:19
 * author: Garden Chan
 * description: NC62 平衡二叉树
 */
public class BalanceTree {
    public boolean isBalanced_Solution(TreeNode root) {
        if (root==null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced_Solution(root.left) && isBalanced_Solution(root.right);
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }

    }
}
