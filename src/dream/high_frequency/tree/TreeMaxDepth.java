package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 1:11
 * author: Garden Chan
 * description: NC13 二叉树的最大深度
 */
public class TreeMaxDepth {
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int maxDepth (TreeNode root) {
        // write code here
        if (root==null) return 0;
        return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
    }
}
