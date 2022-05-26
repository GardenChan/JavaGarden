package dream.sword_offer.medium;

import dream.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * projectName:java-garden
 * see:dream.sword_offer.medium
 * createTime:2021/9/10 10:19
 * author: Jiading chen
 * description: 剑指 Offer 07. 重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 */
public class RebuildTree {
    private Map<Integer, Integer> indexMap;

    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        int n = preOrder.length;
        indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inOrder[i], i);
        }
        return myBuildTree(preOrder, 0, n - 1, inOrder, 0, n - 1);
    }

    private TreeNode myBuildTree(int[] preOrder, int preOrderLeft, int preOrderRight, int[] inOrder, int inOrderLeft, int inOrderRight) {
        if (preOrderLeft > preOrderRight) {
            return null;
        }
        // 根节点在前序遍历的index
        int preOrderRootIndex = preOrderLeft;
        // 获取根节点在中序遍历中的index
        int inOrderRootIndex = indexMap.get(preOrder[preOrderRootIndex]);
        // 建立根节点
        TreeNode root = new TreeNode(preOrder[preOrderRootIndex]);
        // 左子树的节点数目
        int leftSubtreeSize = inOrderRootIndex - inOrderLeft;
        // 递归左子树
        root.left = myBuildTree(preOrder, preOrderLeft + 1, preOrderLeft + leftSubtreeSize, inOrder, inOrderLeft, inOrderRootIndex - 1);
        // 递归右子树
        root.right = myBuildTree(preOrder, preOrderLeft + leftSubtreeSize + 1, preOrderRight, inOrder, inOrderRootIndex + 1, inOrderRight);
        return root;
    }
}
