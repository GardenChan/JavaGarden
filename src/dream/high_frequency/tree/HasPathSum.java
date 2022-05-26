package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/25 1:09
 * author: Garden Chan
 * description: NC9 二叉树中是否存在节点和为指定值的路径
 */
public class HasPathSum {
    /**
     *
     * @param root TreeNode类
     * @param sum int整型
     * @return bool布尔型
     */
    public boolean hasPathSum (TreeNode root, int sum) {
        // write code here
        if (root==null) return false;
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
