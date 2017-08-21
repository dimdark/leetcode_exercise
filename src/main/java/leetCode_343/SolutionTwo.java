package leetCode_343;

/**
 * 观察到对于任意大于4的整数, 其分解成的正整数的乘积均大于该整数<br/>
 * 设2 <= a <= n-2, 则
 *     a * (n - a) - n = (a - 1) * n - a^2 + a - a = (a - 1) * (n - a) - a >= 2 * (a - 1) - a = a - 2 >= 0 <br/>
 * 继续分解, 由于2 * 3 = 3 * 2 = 6 且 2 ^ 3 < 3 ^ 2 故分解成3比分解成2的乘积更大 <br/>
 * 当n为偶数时, 可以分解为 n / 6 * 2 个3和 n%6/2 个 2;
 * 当n为奇数时, 必定有一个3, 故可以分解为 （n - 3) / 6 * 2 + 1 个 3 和 （n - 3) % 6 / 2 个2;
 * @author dimdark
 * @date 2017-08-21
 * @time 10:40 AM
 */
public class SolutionTwo {

    public int integerBreak(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        if(n % 3 == 0) return (int)Math.pow(3, n / 3);
        else if(n % 3 == 1) return (int)Math.pow(3, n / 3 - 1)*4;
        else return (int)Math.pow(3, n / 3) * 2;
    }

}
