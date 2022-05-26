package dream.classic.tree_order;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:Java-Garden
 * see:dream.classic
 * createTime:2021/8/1 23:24
 * author: Garden Chan
 * description: 二叉树的后序遍历
 */
public class PostOrderTraversal {
    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        postOrder(root, res);
        return res;
    }

    private void postOrder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        postOrder(root.left, res);
        postOrder(root.right, res);
        res.add(root.val);
    }
}
