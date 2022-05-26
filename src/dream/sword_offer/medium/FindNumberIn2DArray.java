package dream.sword_offer.medium;

/**
 * projectName:java-garden
 * see:dream.sword_offer.medium
 * createTime:2021/9/10 10:02
 * author: Jiading chen
 * description: 剑指 Offer 04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target){
        // write code here
        if (matrix==null||matrix.length==0||matrix[0].length==0) return false;
        int i = matrix.length-1;
        int j = 0;
        while (isInIndex(matrix, i, j) && matrix[i][j] != target) {
            if (matrix[i][j] < target) {
                j++;
            } else {
                i--;
            }
        }
        return isInIndex(matrix, i, j);
    }

    private boolean isInIndex(int[][] matrix, int row, int col) {
        if (row<0||row>=matrix.length) return false;
        return col >= 0 && col < matrix[0].length;
    }
}
