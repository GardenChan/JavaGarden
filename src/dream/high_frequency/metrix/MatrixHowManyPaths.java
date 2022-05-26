package dream.high_frequency.metrix;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/24 0:04
 * author: Garden Chan
 * description: NC34 求路径
 */
public class MatrixHowManyPaths {
    /**
     *
     * @param m int整型
     * @param n int整型
     * @return int整型
     */
    public int uniquePaths (int m, int n) {
        // write code here
        // dp[i][j] 表示从 [0][0] 到 [i][j]有多少种走法
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }
        return dp[m - 1][n - 1];
    }
}
