package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 10:38
 * author: Garden Chan
 * description: NC98 判断t1树中是否有与t2树拓扑结构完全相同的子树
 */
public class IsContainsTree {
    /**
     *
     * @param root1 TreeNode类
     * @param root2 TreeNode类
     * @return bool布尔型
     */
    public boolean isContains (TreeNode root1, TreeNode root2) {
        // write code here
        if (root1==null) return false;
        return isContains(root1.left, root2) || isContains(root1.right, root2) || isSubTree(root1, root2);
    }

    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
    }
}
