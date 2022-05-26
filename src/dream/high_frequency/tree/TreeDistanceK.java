package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.bytedance.tree
 * createTime:2021/10/11 15:34
 * author: Jiading chen
 * description: LeetCode 863. 二叉树中所有距离为 K 的结点
 */
public class TreeDistanceK {
    static List<Integer> res;
    static TreeNode target;
    static int k;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        res = new ArrayList<>();
        this.target = target;
        this.k = k;
        findParents(root);
        return res;
    }
    private int findParents(TreeNode node) {
        if (node == null) return -1;
        if (node == target) {
            findAns(node, k);
            return k - 1;
        }
        int left = findParents(node.left);
        int right = findParents(node.right);
        if (left > 0) {
            findAns(node.right, left - 1);
            return left - 1;
        } else if (left==0){
            res.add(node.val);
        }
        if (right > 0) {
            findAns(node.left, right - 1);
            return right - 1;
        } else if (right==0){
            res.add(node.val);
        }
        return -1;
    }

    private void findAns(TreeNode node, int i) {
        if (i < 0 || node == null) return;
        if (i == 0) {
            res.add(node.val);
        } else {
            findAns(node.left, i - 1);
            findAns(node.right, i - 1);
        }
    }
}
