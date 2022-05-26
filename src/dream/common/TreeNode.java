package dream.common;

/**
 * projectName:Java-Garden
 * see:dream.common
 * createTime:2021/8/1 23:03
 * author: Garden Chan
 * description: 二叉树的节点
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(int val,TreeNode left,TreeNode right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
