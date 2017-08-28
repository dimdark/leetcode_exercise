package leetCode_378;

import java.util.PriorityQueue;

/**
 * @author dimdark
 * @date 2017-08-28
 * @time 7:58 PM
 */
public class SolutionTwo {

    static class Tuple implements Comparable<Tuple> {
        int x;
        int y;
        int value;
        public Tuple(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        public int compareTo(Tuple t) {
            return this.value - t.value;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Tuple> q = new PriorityQueue<Tuple>(matrix[0].length+1);
        Tuple t;
        for(int i = 0; i < matrix[0].length; ++i) {
            t = new Tuple(0, i, matrix[0][i]);
            q.offer(t);
        }
        for(int i = 1; i < k; ++i) {
            t = q.poll();
            if(t.x+1 < matrix.length) {
                t = new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]);
                q.offer(t);
            }
        }
        return q.poll().value;
    }

}
