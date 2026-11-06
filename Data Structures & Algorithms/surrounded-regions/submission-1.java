class Solution {

    public void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        // 1. Start DFS from top and bottom rows
        for (int col = 0; col < cols; col++) {

            // Top row
            if (board[0][col] == 'O') {
                dfs(board, 0, col);
            }

            // Bottom row
            if (board[rows - 1][col] == 'O') {
                dfs(board, rows - 1, col);
            }
        }

        // 2. Start DFS from left and right columns
        for (int row = 0; row < rows; row++) {

            // Left column
            if (board[row][0] == 'O') {
                dfs(board, row, 0);
            }

            // Right column
            if (board[row][cols - 1] == 'O') {
                dfs(board, row, cols - 1);
            }
        }

        // 3. Convert surrounded O -> X
        //    Restore safe # -> O
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {
                    board[row][col] = 'X';
                }
                else if (board[row][col] == '#') {
                    board[row][col] = 'O';
                }
            }
        }
    }


    private void dfs(char[][] board, int row, int col) {

        // Boundary check
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            board[row][col] != 'O') {
            return;
        }

        // Mark this O as safe
        board[row][col] = '#';

        // Visit all 4 directions
        dfs(board, row - 1, col); // Up
        dfs(board, row + 1, col); // Down
        dfs(board, row, col - 1); // Left
        dfs(board, row, col + 1); // Right
    }
}