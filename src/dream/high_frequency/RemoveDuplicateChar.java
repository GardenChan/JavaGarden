package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.high_frequency
 * createTime:2021/11/10 1:49
 * author: Garden Chan
 * description: LeetCode 1047. 删除字符串中的所有相邻重复项
 */
public class RemoveDuplicateChar {
    public String removeDuplicates(String S) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for (int i = 0; i < S.length(); ++i) {
            char ch = S.charAt(i);
            if (top >= 0 && stack.charAt(top) == ch) {
                stack.deleteCharAt(top);
                --top;
            } else {
                stack.append(ch);
                ++top;
            }
        }
        return stack.toString();
    }
}
