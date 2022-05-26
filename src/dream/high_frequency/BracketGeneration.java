package dream.high_frequency;

import java.util.ArrayList;
import java.util.List;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 20:22
 * author: Jiading chen
 * description: NC26 括号生成
 * 给出n对括号，请编写一个函数来生成所有的由n对括号组成的合法组合。
 * 例如，给出n=3，解集为：
 * "((()))", "(()())", "(())()", "()()()", "()(())",
 */
public class BracketGeneration {
    /**
     *
     * @param n int整型
     * @return string字符串ArrayList
     */
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> result = new ArrayList<>(10);
        backtrack("", 0, 0, n, result);
        return result;
    }

    private void backtrack(String string, int left, int right, int n, List<String> result) {
        if (string.length() == n << 1) {
            result.add(string);
            return;
        }
        if (left < n) {
            backtrack(string+"(", left+1, right, n, result);
        }
        if (right < left) {
            backtrack(string+")", left, right+1, n, result);
        }
    }
}
