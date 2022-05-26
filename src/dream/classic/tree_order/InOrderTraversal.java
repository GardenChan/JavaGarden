package dream.classic.tree_order;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:Java-Garden
 * see:dream.classic
 * createTime:2021/8/1 23:21
 * author: Garden Chan
 * description: 二叉树的中序遍历
 */
public class InOrderTraversal {
    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inOrder(root, res);
        return res;
    }

    private void inOrder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        inOrder(root.left, res);
        res.add(root.val);
        inOrder(root.right, res);
    }
}
