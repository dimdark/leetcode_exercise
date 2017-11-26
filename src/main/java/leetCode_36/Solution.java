package leetCode_36;

/**
 * @author dimdark
 */
public class Solution {

    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return false;
        }
        boolean[][] rowValids = new boolean[9][9];
        boolean[][] columnValids = new boolean[9][9];
        boolean[][] subBoxValids = new boolean[9][9];
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (!Character.isDigit(board[i][j])) {
                    return false;
                }
                int num = board[i][j] - '0' - 1;
                int k = i / 3 * 3 + j / 3; // beautiful
                if (rowValids[i][num] || columnValids[j][num] || subBoxValids[k][num]) {
                    return false;
                }
                rowValids[i][num] = columnValids[j][num] = subBoxValids[k][num] = true;
            }
        }
        return true;
    }

}
