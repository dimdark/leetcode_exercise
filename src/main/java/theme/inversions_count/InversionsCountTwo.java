package theme.inversions_count;

/**
 * 利用分治法来求数组的逆序数<br/>
 * 对于[a1,a2,...,an]来说,其逆序数A(n)=L(n/2)+R(n/2)+Merge(L,R)<br/>
 * 其中，L(n/2)表示数组的左子列表的逆序数,R(n/2)表示数组的右子列表的逆序数,
 * Merge(L,R)表示在合并左子列表和右子列表的过程中新统计的逆序数<br/>
 * 该算法减少了比较的次数，核心在于左右子列表的合并中Merge(L,R)的求法<br/>
 * @author dimdark
 * @date 2017-04-29
 * @time 4:04 PM
 */
public class InversionsCountTwo {

    public static int inversionsCount(int[] a){
        return mergeSort(a,0,a.length);
    }

    private static int mergeSort(int[] a,int start,int end){
        int mid,count=0; //count保存mergeSort方法中数组a的逆序数
        if(start+1<end){
            mid = (start+end)>>1;
            count += mergeSort(a,start,mid);
            count += mergeSort(a,mid,end);
            count += merge(a,start,mid,mid,end);
        }
        return count;
    }

    private static int merge(int[] a,int startA,int endA,int startB,int endB){
        int[] temp = a.clone();
        int startC = startA,count = 0;
        int start = startA,end = endB;
        while (startA<endA && startB<endB){
            if(a[startA]<=a[startB]){
                temp[startC++] = a[startA++];
            }else {
                count += (endA-startA); //合并过程中统计新的逆序数对
                temp[startC++] = a[startB++];
            }
        }
        while (startA<endA){
            temp[startC++] = a[startA++];
        }
        while (startB<endB){
            temp[startC++] = a[startB++];
        }
        //将已排序的子序列[start,end)复制到数组a中
        for (int i=start; i<end; ++i){
            a[i] = temp[i];
        }
        return count;
    }

}
