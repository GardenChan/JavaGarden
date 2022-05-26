package dream.test;

import dream.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.test
 * createTime:2021/9/5 0:16
 * author: Garden Chan
 * description: 二叉树的所有路径
 */
public class BinaryTreePaths {
    public List<String> allPathOfTree(TreeNode root){
        List<String> res = new ArrayList<>();
        if (root==null) return res;
        constructPath(root, "", res);
        return res;
    }

    private void constructPath(TreeNode root, String path, List<String> res) {
        if (root!=null){
            StringBuilder builder = new StringBuilder(path);
            builder.append(root.val);
            if (root.left==null&&root.right==null){
                res.add(builder.toString());
            }else {
                builder.append("->");
                constructPath(root.left, builder.toString(), res);
                constructPath(root.right, builder.toString(), res);
            }
        }
    }
}
