class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int M = obstacleGrid.length;
        int N = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1) return 0;

        obstacleGrid[0][0] = 2;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (obstacleGrid[i][j] != 0) {
                    obstacleGrid[i][j] -= 1;
                } else {
                    if (i > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                    }
                    if (j > 0) {
                        obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                    }
                }
            }
        }
        return obstacleGrid[M - 1][N - 1];
    }
}
