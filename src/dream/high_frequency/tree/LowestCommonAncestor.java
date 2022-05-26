package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/18 1:05
 * author: Garden Chan
 * description: NC102 在二叉树中找到两个节点的最近公共祖先
 */
// @TODO
public class LowestCommonAncestor {
    private Map<Integer, TreeNode> parent = new HashMap<Integer, TreeNode>();
    private Set<Integer> visited = new HashSet<>();

    private void dfs(TreeNode root){
        if (root.left!=null){
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right!=null){
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    /**
     *
     * @param root TreeNode类
     * @param o1 int整型
     * @param o2 int整型
     * @return int整型
     */
    public int lowestCommonAncestor (TreeNode root, int o1, int o2) {
        // write code here
        dfs(root);
        if (root.val == o1 || root.val == o2) {
            return root.val;
        }
        while (parent.containsKey(o1)){
            visited.add(o1);
            o1 = parent.get(o1).val;
        }

        while (!visited.contains(o2)){
            visited.add(o2);
            o2 = parent.get(o2).val;
        }
        return o2;

    }
}
