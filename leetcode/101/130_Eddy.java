class Solution {
    private static int M, N;
    private static boolean[][] visited;
    private static char[][] static_board;

    private static void touch(int i, int j) {
        if (i == -1 || j == -1 || i == M || j == N) return;
        if (visited[i][j]) return;
        if (static_board[i][j] != 'O') return;

        visited[i][j] = true;
        touch(i - 1, j);
        touch(i + 1, j);
        touch(i, j - 1);
        touch(i, j + 1);
    }

    public void solve(char[][] board) {
        M = board.length;
        N = board[0].length;

        visited = new boolean[M][N];
        static_board = board;

        for (int i = 0; i < M; i++) {
            if (i == 0 || i == M - 1) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 'O' && !visited[i][j]) {
                        touch(i, j);
                    }
                }
            } else {
                if (board[i][0] == 'O' && !visited[i][0]) {
                    touch(i, 0);
                }
                if (board[i][N - 1] == 'O' && !visited[i][N - 1]) {
                    touch(i, N - 1);
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
    }
}
