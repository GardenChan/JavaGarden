package dream.high_frequency.longest;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/18 1:46
 * author: Garden Chan
 * description: NC17 最长回文子串
 */
public class LongestPalindrome {
    /**
     * @param A 字符串
     * @param n 字符串长度
     * @return 最长回文字串的长度
     */
    public int getLongestPalindrome(String A, int n) {
        // write code here
        if (n<2) return n;
        int maxLen = 1;
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }
        for (int len = 2; len <= n; len++) {
            for (int begin = 0; begin < n; begin++) {
                int end = begin + len - 1;
                if (end >= n) {
                    break;
                }
                if (A.charAt(begin)!=A.charAt(end)){
                    dp[begin][end] = false;
                }else {
                    if (end-begin<3){
                        dp[begin][end] = true;
                    }else {
                        dp[begin][end] = dp[begin + 1][end - 1];
                    }
                }
                if (dp[begin][end]) {
                    maxLen = Math.max(maxLen, end - begin + 1);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LongestPalindrome getLongestPalindrome = new LongestPalindrome();
        int cbc = getLongestPalindrome.getLongestPalindrome("cbc", 3);
        System.out.println(cbc);
    }
}
