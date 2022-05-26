package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/5 10:33
 * author: Garden Chan
 * description: NC72 二叉树的镜像
 */
public class MirrorOfTree {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param pRoot TreeNode类
     * @return TreeNode类
     */
    public TreeNode mirror (TreeNode pRoot) {
        // write code here
        if (pRoot==null) return null;
        TreeNode left = pRoot.left;
        pRoot.left = pRoot.right;
        pRoot.right = left;
        mirror(pRoot.left);
        mirror(pRoot.right);
        return pRoot;
    }
}
