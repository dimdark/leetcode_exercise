package theme.fenwicktree;

/**
 * @author dimdark
 * @date 2017-04-29
 * @time 7:11 PM
 */
public class FenwickTree {

    //树状数组
    private int[] bit;

    //树状数组的大小(索引从1开始)
    private int size;

    /**
     * 初始化树状数组<br/>
     * @param a     原始数组
     */
    public FenwickTree(int[] a){
        bit = new int[a.length+1];
        size = a.length+1;
        for (int i=0; i<a.length; ++i){
            bit[i+1] = a[i];
        }
        for (int i=1; i<size; ++i){
            int j = i + lsb(i);
            if(j<size){
                bit[j] += bit[i];
            }
        }
    }

    //lsb:least significant bit(最低有效位)
    private int lsb(int i){
        return i&(-i); //返回最低有效位对应的十进制值
    }

    /**
     * 重置原始数组中索引位置为index的元素的值后树状数组的更新<br/>
     * @param index     索引位置
     * @param value     新的元素值
     */
    public void update(int index,int value){
        int delta = value-get(index);
        add(index,delta);
    }

    /**
     * 向原始数组中索引为index的元素添加delta值后更新树状数组<br/>
     * @param index     元素索引
     * @param delta     增加的值
     */
    public void add(int index,int delta){
        for (int i=index; i<=size; i+=lsb(i)){
            bit[i] += delta;
        }
    }

    /**
     * 查询原始数组前x个元素的和<br/>
     * @param x
     * @return
     */
    public int query(int x){
        int sum = 0;
        for (int i=x; i>0; i-=lsb(i)){
            sum += bit[i];
        }
        return sum;
    }

    /**
     * 查询原始数组位于[start,end)内的元素的和<br/>
     * @param oriStart      起始索引
     * @param oriEnd        结束索引(不包括本身)
     * @return
     */
    public int query(int oriStart,int oriEnd){
        return query(oriEnd)-query(oriStart);
    }


    /**
     * 返回位于原始数组索引位置为index的元素的值<br/>
     * @param index     元素索引
     * @return int      对应索引的元素值
     */
    public int get(int index){
        return query(index,index+1);
    }

}
