package theme.inversions_count;

import java.util.Arrays;

/**
 * 利用树状数组求数组的逆序对
 * @author dimdark
 * @date 2017-04-30
 * @time 10:21 AM
 */
public class InversionsCountThree {

    //树状数组
    private static int[] bit;
    //树状数组的大小
    private static int size;

    public static int inversionsCount(int[] a){
        int count = 0;
        bit = new int[a.length+1];
        size = a.length+1;
        convert(a); //离散化数组a
        for (int i=a.length-1; i>-1; --i){
            count += getSum(a[i]-1);
            update(a[i],1);
        }
        return count;
    }

    private static void convert(int[] a){
        int[] temp = a.clone();
        Arrays.sort(temp);
        for (int i=0; i<a.length; ++i){
            a[i] = firstIndexOf(temp,a[i])+1;
        }
//        for (int i=0; i<a.length; ++i){
//            System.out.print(a[i] + " ");
//        }
//        System.out.println();
    }

    private static int firstIndexOf(int[] a,int target){
        for (int i=0; i<a.length; ++i){
            if(a[i]>=target){
                return i;
            }
        }
        return -1;
    }

    /**
     * 返回原始数组前x个元素的和<br/>
     * @param x
     * @return
     */
    private static int getSum(int x){
        int sum = 0;
        for (int i=x; i>0; i-=lsb(i)){
            sum += bit[i];
        }
        return sum;
    }

    /**
     * 在数组索引位置为x的元素添加了delta后更新整个树状数组<br/>
     * @param x     元素索引
     * @param delta 增加的值
     */
    private static void update(int x,int delta){
        for (int i=x; i<size; i+=lsb(i)){
            bit[i] += delta;
        }
    }

    private static int lsb(int i){
        return i&(-i);
    }


}
