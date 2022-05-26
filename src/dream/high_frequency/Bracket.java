package dream.high_frequency;

import java.util.Stack;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/10 23:33
 * author: Garden Chan
 * description: NC52 括号序列
 */
public class Bracket {
    /**
     * @param s string字符串
     * @return bool布尔型
     */
    public boolean isValid (String s) {
        // write code here
        char[] input = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            switch (c){
                case '(':
                    stack.push('(');
                    break;
                case ')':
                    if (stack.size()==0||!stack.peek().equals('(')) return false;
                    stack.pop();
                    break;
                case '[':
                    stack.push('[');
                    break;
                case ']':
                    if (stack.size()==0||!stack.peek().equals('[')) return false;
                    stack.pop();
                    break;
                case '{':
                    stack.push('{');
                    break;
                case '}':
                    if (stack.size()==0||!stack.peek().equals('{')) return false;
                    stack.pop();
                    break;
            }
        }
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        Bracket bracket = new Bracket();
        boolean valid = bracket.isValid("]");
        System.out.println(valid);

    }
}
