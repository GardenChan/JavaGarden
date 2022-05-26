package dream.high_frequency.metrix;

import java.util.ArrayList;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/18 1:23
 * author: Garden Chan
 * description: NC38 螺旋矩阵
 */
public class MatrixSpiralOrder {
    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length==0) return res;
        int row = matrix.length;
        int col = matrix[0].length;
        circle(matrix, 0, 0, row - 1, col - 1, res);
        return res;
    }

    private void circle(int[][] matrix, int x1, int y1, int x2, int y2, ArrayList<Integer> res) {
        if (x2 < x1 || y2 < y1) {
            return;
        }
        if (x1 == x2) {
            for (int i = y1; i <= y2; i++) res.add(matrix[x1][i]);
            return;
        }
        if (y1 == y2) {
            for (int i = x1; i <= x2; i++) res.add(matrix[i][y1]);
            return;
        }
        // 从左往右
        for (int i = y1; i < y2; i++) res.add(matrix[x1][i]);
        // 从上往下
        for (int i = x1; i < x2; i++) res.add(matrix[i][y2]);
        // 从右往左
        for (int i = y2; i > y1; i--) res.add(matrix[x2][i]);
        // 从下往上
        for (int i = x2; i > x1; i--) res.add(matrix[i][y1]);
        circle(matrix, x1 + 1, y1 + 1, x2 - 1, y2 - 1, res);
    }

    public static void main(String[] args) {
        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        MatrixSpiralOrder matrixSpiralOrder = new MatrixSpiralOrder();
        ArrayList<Integer> integers = matrixSpiralOrder.spiralOrder(input);
        System.out.println(integers);
    }
}
