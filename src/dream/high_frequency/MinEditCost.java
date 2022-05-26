package dream.high_frequency;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/22 18:44
 * author: Garden Chan
 * description: NC35 最小编辑代价
 */
public class MinEditCost {
    /**
     * min edit cost
     * @param str1 string字符串 the string
     * @param str2 string字符串 the string
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public int minEditCost (String str1, String str2, int ic, int dc, int rc) {
        // write code here
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i * dc;
        }
        for (int i=0;i<=len2;i++){
            dp[0][i] = i * ic;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                int a = dp[i - 1][j] + dc;
                int b = dp[i][j - 1] + ic;
                int c = dp[i - 1][j - 1];
                if (str1.charAt(i-1)!=str2.charAt(j-1)) c += rc;
                dp[i][j] = Math.min(a, Math.min(b, c));
            }
        }
        return dp[len1][len2];
    }
}
