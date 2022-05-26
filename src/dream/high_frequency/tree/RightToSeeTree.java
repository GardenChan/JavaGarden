package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 0:48
 * author: Garden Chan
 * description: NC136 输出二叉树的右视图
 */
public class RightToSeeTree {
    /**
     * 求二叉树的右视图
     * @param root 二叉树根节点
     * @return int整型一维数组
     */
    public int[] solve (TreeNode root) {
        // write code here
        if (root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
                if (i==0) ans.add(poll.val);
            }
        }
        int[] res = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }
}
