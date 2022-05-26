package dream.high_frequency.longest;

/**
 * projectName:java-garden
 * see:dream.bytedance.longest
 * createTime:2021/9/8 21:39
 * author: Jiading chen
 * description: NC49 最长的括号子串
 */
public class LongestValidBracket {
    /**
     *
     * @param s string字符串
     * @return int整型
     */
    public int longestValidParentheses (String s) {
        // write code here
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }
}
