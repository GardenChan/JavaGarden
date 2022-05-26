package dream.high_frequency.metrix;

/**
 * projectName:Java-Garden
 * see:dream.bytedance
 * createTime:2021/8/20 0:56
 * author: Garden Chan
 * description: NC109 岛屿数量
 */
public class IslandNumbers {
    /**
     * 判断岛屿数量
     * @param grid char字符型二维数组
     * @return int整型
     */
    public int solve (int[][] grid) {
        if (grid.length==0 || grid[0].length==0) return 0;
        // write code here
        int nums = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==1){
                    dfs(grid,i,j);
                    nums++;
                }
            }
        }
        return nums;
    }

    private void dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }

    public static void main(String[] args) {
//        int[][] input = {{1, 1, 0, 0, 0}, {0, 1, 0, 1, 1}, {0, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 1, 1}};
//        int[][] input = {{1}};
        int[][] input = {{0}};
        IslandNumbers islandNumbers = new IslandNumbers();
        int solve = islandNumbers.solve(input);
        System.out.println(solve);

    }
}
