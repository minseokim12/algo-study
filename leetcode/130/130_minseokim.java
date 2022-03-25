


// Runtime: 32 ms, faster than 5.09% of Java online submissions for Surrounded Regions.
// Memory Usage: 74.4 MB, less than 5.09% of Java online submissions for Surrounded Regions.
//
// O(mn) solution
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (board[i][j] != 'X') {
                    boolean[][] visited = new boolean[m][n];
                    boolean surrounded = travel(board, i, j, visited);
                    
                    if (surrounded) {
                        updateByVisitedSpots(board, visited);
                    }
                }
            }
        }
    }
    
    public boolean travel(char[][] board, int i, int j, boolean[][] visited){
        visited[i][j] = true;
        
        if (i == 0 || j == 0 || i == board.length -1 || j == board[0].length -1 || board[i][j] != 'O') {
            return board[i][j] == 'X';
        }
        
        boolean result = true;
        if (board[i-1][j] == 'O' && !visited[i-1][j]) {
            result = result && travel(board, i-1, j, visited);
        }
        if (board[i+1][j] == 'O' && !visited[i+1][j]) {
            result = result && travel(board, i+1, j, visited);
        }
        
        if (board[i][j-1] == 'O' && !visited[i][j-1]) {
            result = result && travel(board, i, j-1, visited);
        }
        
        if (board[i][j+1] == 'O' && !visited[i][j+1]) {
            result = result && travel(board, i, j+1, visited);
        }
              
        return result;
    }
    
    public void updateByVisitedSpots(char[][] board, boolean[][] visited) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                if (visited[i][j]) {
                    System.out.println(String.format("%d, %d: updated to X", i, j));
                    board[i][j] = 'X';
                }
            }
        }   
    }
    
}

