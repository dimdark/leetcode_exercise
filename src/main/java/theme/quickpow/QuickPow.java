package theme.quickpow;

/**
 * 快速幂实现类
 * @author dimdark
 * @date 2017-08-23
 * @time 10:21 AM
 */
public class QuickPow {

    public static int qPow(int a, int n) {
        if(n == 0) return 1;
        int rst = 1;
        while (n != 0) {
           if((n&1) == 1) rst *= a;
           a *= a;
           n >>= 1;
        }
        return rst;
    }

    public static long qPow(long a, int n) {
        if(n == 0) return 1;
        long rst = 1;
        while (n != 0) {
            if((n&1) == 1) rst *= a;
            a *= a;
            n >>= 1;
        }
        return rst;
    }

}
