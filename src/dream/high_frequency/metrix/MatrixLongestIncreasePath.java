package dream.high_frequency.metrix;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/8 16:22
 * author: Jiading chen
 * description: 矩阵最长递增路径
 */
public class MatrixLongestIncreasePath {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     * 递增路径的最大长度
     * @param matrix int整型二维数组 描述矩阵的每个数
     * @return int整型
     */
    public int solve (int[][] matrix) {
        int max = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return max;
        }
        // 以所有的节点为路径的开始节点
        for (int i = 0;i < matrix.length;++i){
            for (int j = 0;j < matrix[0].length;++j){
                // 计算从（i，j）开始的最长递增路径
                int temp = searchMaxPath(matrix,i,j,-1);
                max = Math.max(temp,max);
            }
        }
        return max;
    }
    // 计算以点（row，col）为路径头结点的最长递增路径
    private int searchMaxPath(int[][] matrix,int row,int col,int pre){
        if (row < 0 || col < 0 ||
                row >= matrix.length || col >= matrix.length){
            return 0;
        }
        if (matrix[row][col] <= pre){
            return 0;
        }

        int max = 0;
        int temp = 0;
        // 点（row，col）往上走的最长路径
        temp = searchMaxPath(matrix,row-1,col,matrix[row][col]);
        max = Math.max(temp,max);
        // 点（row，col）往下走的最长路径
        temp = searchMaxPath(matrix,row+1,col,matrix[row][col]);
        max = Math.max(temp,max);
        // 点（row，col）往左走的最长路径
        temp = searchMaxPath(matrix,row,col-1,matrix[row][col]);
        max = Math.max(temp,max);
        // 点（row，col）往右走的最长路径
        temp = searchMaxPath(matrix,row,col+1,matrix[row][col]);
        max = Math.max(temp,max);
        return max+1;
    }
}
