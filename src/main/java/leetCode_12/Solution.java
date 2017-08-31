package leetCode_12;

/**
 * @author dimdark
 * @date 2017-08-30
 * @time 10:11 AM
 */
public class Solution {

    public String intToRoman(int num) {
        // roman number
        // I ---> 1, X ---> 10, C ---> 100, M ---> 1000
        // V ---> 5, L ---> 50, D ---> 500
        final String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}; // 1-9
        final String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}; // 10-90
        final String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}; // 100-900
        final String[] M = {"", "M", "MM", "MMM"}; // 1000-3000
        StringBuilder rst = new StringBuilder();
        rst.append(M[num/1000]).append(C[num%1000/100]).append(X[num%100/10]).append(I[num%10]);
        return rst.toString();
    }

}
