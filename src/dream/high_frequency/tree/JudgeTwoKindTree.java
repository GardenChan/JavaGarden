package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/6 10:14
 * author: Jiading chen
 * description: NC60 判断一棵二叉树是否为搜索二叉树和完全二叉树
 */
//@TODO
public class JudgeTwoKindTree {
    /**
     *
     * @param root TreeNode类 the root
     * @return bool布尔型一维数组
     */
    public boolean[] judgeIt (TreeNode root) {
        // write code here
        boolean[] res = new boolean[2];
        res[0] = isSearchTree(root);
        res[1] = isAllTree(root);
        return res;
    }

    private boolean isAllTree(TreeNode root) {
        if (root==null) return true;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left==null&&poll.right!=null) return false;
                if (flag&&(poll.left!=null||poll.right!=null)){
                    return false;
                }
                if (!flag && (poll.left == null || poll.right == null)) {
                    flag = true;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }

            }
        }
        return true;
    }
    private boolean isSearchTree(TreeNode root) {
        if (root==null) return true;
        if (root.left!=null&&root.val<root.left.val) return false;
        if (root.right!=null&&root.val>root.right.val) return false;
        return isSearchTree(root.left) && isSearchTree(root.right);
    }
}
