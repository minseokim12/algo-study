class Solution {
    public int maximalRectangle(char[][] matrix) {
        int N = matrix.length;
        int M = matrix[0].length;

        int max_square_size = 0;
        int[][] max_square = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }

                if (i == 0 || j == 0) {
                    max_square[i][j] = 1;
                } else {
                    max_square[i][j] = 1 + min(max_square[i - 1][j], max_square[i][j - 1], max_square[i - 1][j - 1]);
                }
                max_square_size = Math.max(max_square_size, max_square[i][j]);
            }
        }

        int ans = 0;
        int max_count, count;
        for (int size = 1; size <= max_square_size; size++) {
            max_count = 0;
            for (int i = 0; i < N; i++) {
                count = 0;
                for (int j = 0; j < M; j++) {
                    if (size <= max_square[i][j]) {
                        max_count = Math.max(max_count, ++count);
                    } else {
                        count = 0;
                    }
                }
            }
            if (max_count > 0) {
                ans = Math.max(ans, size * (size + max_count - 1));
            }
        }


        for (int size = 1; size <= max_square_size; size++) {
            max_count = 0;
            for (int j = 0; j < M; j++) {
                count = 0;
                for (int i = 0; i < N; i++) {
                    if (size <= max_square[i][j]) {
                        max_count = Math.max(max_count, ++count);
                    } else {
                        count = 0;
                    }
                }
            }
            if (max_count > 0) {
                ans = Math.max(ans, size * (size + max_count - 1));
            }
        }

        return ans;
    }

    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}
