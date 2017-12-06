package leetCode_37;

import java.util.Arrays;

/**
 * @author dimdark
 */
public class Solution {

    private boolean[][] columns = new boolean[9][9];
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] boxes = new boolean[9][9];

    public Solution() {
        for (int i = 0; i < 9; ++i) {
            Arrays.fill(columns[i], false);
            Arrays.fill(rows[i], false);
            Arrays.fill(boxes[i], false);
        }
    }

    public void solveSudoku(char[][] board) {
        int num;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] != '.') {
                    num = board[i][j] - '0' - 1;
                    columns[j][num] = true;
                    rows[i][num] = true;
                    boxes[j / 3 + i / 3 * 3][num] = true;
                }
            }
        }
        backtrack(board, 0, 0);
    }

    private boolean backtrack(char[][] board, int x, int y) {
        if (x == 9) {
            return true;
        }
        int ny = (y + 1) % 9;
        int nx = ny == 0 ? x + 1 : x;
        int boxIdx = x / 3 * 3 + y / 3;
        if (board[x][y] != '.') {
            return backtrack(board, nx, ny);
        }
        for (int i = 1; i <= 9; ++i) {
            if (!columns[y][i - 1] && !rows[x][i - 1] && !boxes[boxIdx][i - 1]) {
                board[x][y] = (char)(i + '0');
                columns[y][i - 1] = true;
                rows[x][i - 1] = true;
                boxes[boxIdx][i - 1] = true;
                if (backtrack(board, nx, ny)) {
                    return true;
                }
                board[x][y] = '.';
                columns[y][i - 1] = false;
                rows[x][i - 1] = false;
                boxes[boxIdx][i - 1] = false;
            }
        }
        return false;
    }

}
