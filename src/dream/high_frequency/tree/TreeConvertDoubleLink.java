package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;


/**
 * projectName:java-garden
 * see:dream.bytedance.tree
 * createTime:2021/9/8 9:37
 * author: Jiading chen
 * description: NC64 二叉搜索树与双向链表
 */
public class TreeConvertDoubleLink {
    public TreeNode convert(TreeNode pRootOfTree) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        preOrder(pRootOfTree, queue);
        if (queue.isEmpty()) return null;
        TreeNode head = queue.poll();
        head.left = null;
        head.right = null;
        TreeNode node = head;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            node.right = poll;
            poll.left = node;
            poll.right = null;
            node = node.right;
        }
        return head;
    }

    private void preOrder(TreeNode pRootOfTree, Queue<TreeNode> queue) {
        if (pRootOfTree==null) return;
        preOrder(pRootOfTree.left,queue);
        queue.offer(pRootOfTree);
        preOrder(pRootOfTree.right,queue);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(14);
        node1.left = node2;
        node1.right = node3;
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(8);
        node2.left = node4;
        node2.right = node5;
        TreeNode node6 = new TreeNode(12);
        TreeNode node7 = new TreeNode(16);
        node3.left = node6;
        node3.right = node7;
        TreeConvertDoubleLink treeConvertDoubleLink = new TreeConvertDoubleLink();
        TreeNode convert = treeConvertDoubleLink.convert(node1);
        while (convert!=null){
            System.out.print(convert.val + " ");
            convert = convert.right;
        }
    }
}
