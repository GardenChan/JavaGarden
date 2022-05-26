package dream.high_frequency.metrix;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/24 23:59
 * author: Garden Chan
 * description: NC86 矩阵元素查找
 */
public class FindElement {
    public int[] findElement(int[][] mat, int n, int m, int x) {
        // write code here
        int i = n - 1;
        int j = 0;
        while (mat[i][j]!=x){
            if (mat[i][j]<x){
                j++;
            }else {
                i--;
            }
        }
        int[] ans = new int[2];
        ans[0] = i;
        ans[1] = j;
        return ans;
    }
}
