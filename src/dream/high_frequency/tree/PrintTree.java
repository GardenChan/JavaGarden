package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/16 22:53
 * author: Garden Chan
 * description: NC14 按之字形顺序打印二叉树
 */
public class PrintTree {
    /**
     * 层序遍历
     * @param pRoot 树的根节点
     * @return 嵌套列表
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot==null) return res;
        queue.add(pRoot);
        while (!queue.isEmpty()){
            int size = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            for (int i = size; i > 0; i--) {
                TreeNode poll = queue.poll();
                integers.add(poll.val);
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
            }
            res.add(integers);
        }
        for (int i = res.size() - 1; i >= 0; i--) {
            if (i%2==1){
                reverseList(res.get(i));
            }
        }
        return res;
    }

    private void reverseList(ArrayList<Integer> arrayList) {
        Stack<Integer> stack = new Stack<>();
        int size = arrayList.size();
        for (int i = size; i > 0; i--) {
            stack.push(arrayList.remove(0));
        }
        for (int i = size; i > 0; i--) {
            arrayList.add(stack.pop());
        }
    }
}
