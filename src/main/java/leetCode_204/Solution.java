package leetCode_204;

/**
 * @author dimdark
 * @date 2017-08-22
 * @time 10:40 AM
 */
public class Solution {

    public int countPrimes(int n) {
        if(n == 0 || n == 1 || n == 2) return 0;
        byte[] primes = new byte[n/2+(n&1)-1];
        int primeCnt, bound;
        primeCnt = 1;
        bound = (int)Math.sqrt(n);
        for(int i = 3; i < bound + 1; i += 2) {
            int idx = (i-3)/2;
            if(primes[idx] != 1) {
                for(int j = 3 * i; j <= n; j += (2*i)) {
                    primes[(j-3)/2] = 1;
                }
            }
        }
        for(int i = 0; i < primes.length; ++i) {
            if(primes[i] != 1) primeCnt++;
        }
        if((n%2==1) && (n-3)/2<primes.length && primes[(n-3)/2] != 1) primeCnt--;
        return primeCnt;
    }

}
