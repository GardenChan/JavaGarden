package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 10:50
 * author: Garden Chan
 * description: NC117 合并二叉树
 * 已知两颗二叉树，将它们合并成一颗二叉树。
 * 合并规则是：都存在的结点，就将结点值加起来，否则空的位置就由另一个树的结点来代替。
 */
public class MergeTrees {
    /**
     *
     * @param t1 TreeNode类
     * @param t2 TreeNode类
     * @return TreeNode类
     */
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null || t2 == null) {
            return t1 == null ? t2 : t1;
        }
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
