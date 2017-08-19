package theme.inversions_count;

/**
 * 求给定的一个数组的逆序数<br/>
 * brutal force: O(n^2)<br/>
 * @author dimdark
 * @date 2017-04-29
 * @time 3:49 PM
 */
public class InversionsCountOne {

    public static int inversionsCount(int[] a){
        int i,j,count=0;
        for (i=1; i<a.length; ++i){
            for (j=i; j>0; --j){
                if(a[j-1]>a[i]){
                    ++count;
                }
            }
        }
        return count;
    }

}
