package dream.high_frequency.metrix;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 1:05
 * author: Garden Chan
 * description: NC108 最大正方形
 *
 * 给定一个由'0'和'1'组成的2维矩阵，
 * 返回该矩阵中最大的由'1'组成的正方形的面积，
 * 输入的矩阵是字符形式而非数字形式。
 */
public class MaxSquare {
    /**
     * 最大正方形
     * 我们用dp(i,j) 表示以 (i, j) 为右下角，且只包含 1 的正方形的边长最大值。
     * @param matrix char字符型二维数组
     * @return int整型
     */
    public int solve (char[][] matrix) {
        // write code here
        int maxSide = 0;
        if (matrix==null||matrix.length==0||matrix[0].length==0) return maxSide;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        // 最左列
        for (int i = 0; i < row; i++) {
            if (matrix[i][0]=='1'){
                dp[i][0] = 1;
                maxSide = Math.max(maxSide, dp[i][0]);
            }else {
                dp[i][0] = 0;
            }
        }
        // 最右列
        for (int i = 0; i < col; i++) {
            if (matrix[0][i]=='1'){
                dp[0][i] = 1;
                maxSide = Math.max(maxSide, dp[0][i]);
            }else {
                dp[0][i] = 0;
            }
        }
        for (int i = 1; i <= row - 1; i++) {
            for (int j = 1; j <= col - 1; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxSide = Math.max(dp[i][j], maxSide);
                }
            }
        }
        return maxSide * maxSide;
    }
}
