class Solution {
    public int minPathSum(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int val = 0;
                if (i == 0 && j == 0) {

                } else if (i == 0 && j > 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (i > 0 && j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[N - 1][M - 1];
    }
}
