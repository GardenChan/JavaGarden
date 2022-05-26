package dream.high_frequency;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 20:47
 * author: Jiading chen
 * description: NC87 丢棋子问题
 * @比较难
 */
public class DropChess {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 返回最差情况下扔棋子的最小次数
     * @param N int整型 楼层数
     * @param K int整型 棋子数
     * @return int整型
     */
    public int solve (int N, int K) {
        // write code here
        if ( N<1 || K<1 )
            return 0;
        if ( K == 1 ) return N;
        int[][] dp = new int[N+1][K+1];
        for(int i=1; i<dp.length; ++i) {
            dp[i][1] = i;
        }
        for(int i=1; i<dp.length; ++i) {
            for(int j=2; j<=K; ++j) {
                int min = Integer.MAX_VALUE;
                for(int k=1; k<i+1; ++k) {
                    min = Math.min(min, Math.max(dp[k-1][j-1], dp[i-k][j]));
                }
                dp[i][j] = min + 1;
            }
        }
        return dp[N][K];
    }

    public static void main(String[] args) {
        DropChess dropChess = new DropChess();
        int solve = dropChess.solve(874520, 7);
        System.out.println(solve);
    }
}
