package dream.high_frequency;

import java.util.Stack;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/16 22:34
 * author: Garden Chan
 * description: NC1 大数加法
 */
public class StringAdd {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 计算两个数之和
     * @param s string字符串 表示第一个整数
     * @param t string字符串 表示第二个整数
     * @return string字符串
     */
    public String solve (String s, String t) {
        // write code here
        Stack<Integer> stack = new Stack<>();
        int sLen = s.length() - 1, tLen = t.length() - 1, carry = 0;
        while (sLen>=0 || tLen>=0||carry>0){
            carry += sLen >= 0 ? s.charAt(sLen--) - '0' : 0;
            carry += tLen >= 0 ? t.charAt(tLen--) - '0' : 0;
            stack.push(carry % 10);
            carry /= 10;
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()){
            builder.append(stack.pop());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String s = "561545";
        String t = "999999";
        StringAdd add = new StringAdd();
        String solve = add.solve(s, t);
        System.out.println(solve);
        System.out.println(561545+999999);
    }
}
