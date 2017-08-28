package leetCode_378;

/**
 * @author dimdark
 * @date 2017-08-28
 * @time 6:51 PM
 */
public class Solution {

    static class Tuple implements Comparable<Tuple>{
        int x;
        int y;
        int value;
        public Tuple(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        public int compareTo(Tuple o) {
            return this.value - o.value;
        }
    }

    private void createMinHeap(Tuple[] heap) {
        for(int i = (heap.length-1)/2; i > 0; --i) {
            adjust(heap, i, heap.length);
        }
    }

    private void adjust(Tuple[] heap, int target, int border) { // border不可取
        heap[0] = new Tuple(heap[target].x, heap[target].y, heap[target].value); //哨兵
        for(int i = 2*target; i < border; i *= 2) {
            if(i+1<border && heap[i].compareTo(heap[i+1])>0) i++;
            if(heap[0].compareTo(heap[i])<=0) break;
            heap[target].x = heap[i].x;
            heap[target].y = heap[i].y;
            heap[target].value = heap[i].value;
            target = i;
        }
        heap[target].x = heap[0].x;
        heap[target].y = heap[0].y;
        heap[target].value = heap[0].value;
    }

    public int kthSmallest(int[][] matrix, int k) {
        Tuple[] heap = new Tuple[matrix[0].length+1];
        for(int i = 0; i < matrix[0].length; ++i) {
            heap[i+1] = new Tuple(0, i, matrix[0][i]);
        }
        createMinHeap(heap); // 建立最小堆
        int validLen = heap.length-1;
        for(int i = 1; i < k; ++i) {
            if(heap[1].x+1 < matrix.length) {
                heap[1].value = matrix[heap[1].x+1][heap[1].y];
                heap[1].x = heap[1].x+1; // heap[1].y = heap[1].y;
                adjust(heap, 1, validLen+1);
            }else {
                heap[1].x = heap[validLen].x;
                heap[1].y = heap[validLen].y;
                heap[1].value = heap[validLen].value;
                validLen--;
                adjust(heap, 1, validLen+1);
            }
        }
        return heap[1].value;
    }

}
