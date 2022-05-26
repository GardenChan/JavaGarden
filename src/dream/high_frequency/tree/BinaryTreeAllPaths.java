package dream.high_frequency.tree;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/23 23:02
 * author: Garden Chan
 * description: Leetcode 257. 二叉树的所有路径
 */
public class BinaryTreeAllPaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String path, List<String> paths) {
        if(root!=null){
            StringBuilder pathSB = new StringBuilder(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {
                paths.add(pathSB.toString());
            }else {
                pathSB.append("->");
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}
