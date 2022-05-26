package dream.classic.tree_order;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:Java-Garden
 * see:dream.classic
 * createTime:2021/8/1 23:01
 * author: Garden Chan
 * description: 二叉树的前序遍历
 */
public class PreOrderTraversal {
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<>();
        preOrder(root, res);
        return res;
    }

    private void preOrder(TreeNode root, List<Integer> res) {
        if (root==null) return;
        res.add(root.val);
        preOrder(root.left, res);
        preOrder(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);

        root.left = node1;
        root.right = node2;

        node1.left = node3;
        node2.right = node4;

        PreOrderTraversal preOrderTraversal = new PreOrderTraversal();
        List<Integer> answer = preOrderTraversal.preOrderTraversal(root);
        System.out.println(answer);
    }
}
