package theme.inversions_count;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 求一个数组中满足i<j<k&&a[i]<a[j]<a[k]的triplet的总数<br/>
 * @author dimdark
 * @date 2017-04-30
 * @time 12:10 PM
 */
public class InversionsCountFour {

    public static void main(String[] args) {
        int i,t,n;
        int[] a;
        Scanner in = new Scanner(System.in);
        t = in.nextInt();
        while (t--!=0){
            n = in.nextInt();
            a = new int[n];
            for (i=0; i<n; ++i){
                a[i] = in.nextInt();
            }
//            for (i=0; i<n; ++i){
//                System.out.printf("%d ",a[i]);
//            }
//            System.out.println();
            System.out.println(magicTriplet(a));
        }
    }

    private static long magicTriplet(int[] a){
        if(a.length<3){
            return 0;
        }else if(a.length==3){
            return (a[0]<a[1]&&a[1]<a[2])?1:0;
        }else {
            return inversionCount(a);
        }
    }

    private static long inversionCount(int[] a){
        convert(a);
        int[] bit1 = new int[a.length+1];
        int[] bit2 = new int[a.length+1];
        long[] first = new long[a.length];
        long[] second = new long[a.length];
        long count = 0;
        //i<j && a[i]<a[j]
        for (int i=0; i<a.length; ++i){
            first[i] = getSum(bit1,a[i]-1);
            update(bit1,a[i],1);
        }
        //j<k && a[j]>a[k]
        for (int i=a.length-1; i>-1; --i){
            second[i] = a.length-1-i-getSum(bit2,a[i]);
            update(bit2,a[i],1);
        }
        for (int i=0; i<a.length; ++i){
            count += first[i]*second[i];
        }
        return count;
    }

    private static void convert(int[] a){
        int[] temp = a.clone();
        Arrays.sort(temp);
        for (int i=0; i<a.length; ++i){
            a[i] = firstIndexOf(temp,a[i])+1;
        }
    }

    private static int firstIndexOf(int[] a,int target){
        for (int i=0; i<a.length; ++i){
            if(a[i]>=target){
                return i;
            }
        }
        return -1;
    }

    private static int getSum(int[] bit,int x){
        int sum = 0;
        for (int i=x; i>0; i-=lsb(i)){
            sum += bit[i];
        }
        return sum;
    }

    private static void update(int[] bit,int x,int delta){
        for (int i=x; i<bit.length; i+=lsb(i)){
            bit[i] += delta;
        }
    }

    private static int lsb(int i){
        return i&(-i);
    }

}
