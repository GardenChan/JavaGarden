package dream.high_frequency.tree;

import dream.common.TreeNode;

/**
 * projectName:java-garden
 * see:dream.bytedance.tree
 * createTime:2021/9/8 21:42
 * author: Jiading chen
 * description: NC123 序列化二叉树
 */
public class TreeSerialize {
    //String str = "";
    private int index = -1;

    String Serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        SerializeHelp(root, sb);
        return sb.toString();
    }

    //主要实现前序遍历，然后加上#和！
    void SerializeHelp(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#!");
            return;
        }
        sb.append(root.val).append("!");
        SerializeHelp(root.left, sb);
        SerializeHelp(root.right, sb);
    }

    TreeNode Deserialize(String str) {
        if(str == null || str == ""){
            return null;
        }
        String[] strs = str.split("!"); //利用结束符分割出每个节点的值便于处理。
        return DeserializeHelp(strs);
    }

    TreeNode DeserializeHelp(String[] strs){
        index++;
        if(!strs[index].equals("#")){ //按顺序添加各节点。
            TreeNode node = new TreeNode(Integer.parseInt(strs[index]));
            node.left = DeserializeHelp(strs);
            node.right = DeserializeHelp(strs);
            return node;
        }
        return null;
    }
}
