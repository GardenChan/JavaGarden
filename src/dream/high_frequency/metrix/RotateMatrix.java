package dream.high_frequency.metrix;

import java.util.Arrays;

/**
 * projectName:java-garden
 * see:dream.bytedance
 * createTime:2021/9/7 16:47
 * author: Jiading chen
 * description: NC18 顺时针旋转矩阵
 */
public class RotateMatrix {
    public int[][] rotateMatrix(int[][] mat, int n) {
        // write code here
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = n; j > 0; j--) {
                res[i][n - j] = mat[j - 1][i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{1,2,3}, {4,5,6}, {7,8,9}};
        RotateMatrix rotateMatrix = new RotateMatrix();
        int[][] res = rotateMatrix.rotateMatrix(input, input.length);
        System.out.println(Arrays.deepToString(res));
    }
}
