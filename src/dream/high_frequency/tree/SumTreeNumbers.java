package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/23 22:49
 * author: Garden Chan
 * description: NC5 二叉树根节点到叶子节点的所有路径和
 */
public class SumTreeNumbers {
    private int answer = 0;
    /**
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int sumNumbers (TreeNode root) {
        // write code here
        calculateSumOfTreePath(root, 0);
        return answer;
    }

    private void calculateSumOfTreePath(TreeNode root, int now) {
        if (root!=null){
            int num = now*10+root.val;
            if (root.left == null && root.right == null) {
                answer += num;
            }else {
                calculateSumOfTreePath(root.left, num);
                calculateSumOfTreePath(root.right, num);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(9);
        SumTreeNumbers sumTreeNumbers = new SumTreeNumbers();
        int i = sumTreeNumbers.sumNumbers(treeNode);
        System.out.println(i);
    }
}
