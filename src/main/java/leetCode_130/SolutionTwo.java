package leetCode_130;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dimdark
 * @date 2017-09-03
 * @time 11:24 AM
 */
public class SolutionTwo {

    static class Pair {
        int x;
        int y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private void bfs(char[][] board, int i, int j, int col, int row) {
        if(board[i][j] == 'O') {
            Queue<Pair> q = new LinkedList<Pair>();
            board[i][j] = 'Y';
            Pair p = new Pair(i, j);
            q.add(p);
            while (q.size() != 0) {
                p = q.peek();
                q.remove();
                if (p.x > 0 && board[p.x-1][p.y] == 'O') { // left
                    board[p.x-1][p.y] = 'Y';
                    q.add(new Pair(p.x-1, p.y));
                }
                if (p.y > 0 && board[p.x][p.y-1] == 'O') { // up
                    board[p.x][p.y-1] = 'Y';
                    q.add(new Pair(p.x, p.y-1));
                }
                if (p.x < col-1 && board[p.x+1][p.y] == 'O') { // right
                    board[p.x+1][p.y] = 'Y';
                    q.add(new Pair(p.x+1, p.y));
                }

                if (p.y < row-1 && board[p.x][p.y+1] == 'O') { // down
                    board[p.x][p.y+1] = 'Y';
                    q.add(new Pair(p.x, p.y+1));
                }
            }
        }
    }
    public void solve(char[][] board) {
        if (board.length == 0) return;
        int col = board.length, row = board[0].length;
        for (int i = 0; i < col; ++i) {
            bfs(board, i, 0, col, row);
            if (row > 1) bfs(board, i, row-1, col, row);
        }
        for (int i = 1; i < row-1; ++i) {
            bfs(board, 0, i, col, row);
            if (col > 1) bfs(board, col-1, i, col, row);
        }
        for (int i = 0; i < col; ++i) {
            for (int j = 0; j < row; ++j) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                else if(board[i][j] == 'Y') board[i][j] = 'O';
            }
        }
    }

}
