package dream.high_frequency.metrix;

/**
 * projectName:java-garden
 * see:dream.bytedance.metrix
 * createTime:2021/10/11 15:41
 * author: Jiading chen
 * description: LeetCode 931. 下降路径最小和
 */
public class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<n; j++){
                if(j == 0){
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }else if(j == n-1){
                    matrix[i][j] = matrix[i][j]+Math.min(matrix[i-1][j],matrix[i-1][j-1]);
                }else{
                    matrix[i][j] = matrix[i][j]+Math.min(Math.min(matrix[i-1][j],matrix[i-1][j-1]),matrix[i-1][j+1]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for(int in:matrix[n-1]){
            ans = Math.min(in,ans);
        }
        return ans;
    }
}
