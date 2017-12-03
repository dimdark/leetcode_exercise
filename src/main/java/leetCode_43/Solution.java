package leetCode_43;

import java.util.Arrays;

/**
 * @author dimdark
 */
public class Solution {

    public String multiply(String num1, String num2) {
        if (num1 == null || num1.length() == 0 || num2 == null || num2.length() ==0) {
            return null;
        }
        char[] cs1 = reverse(num1).toCharArray();
        int len1 = cs1.length;
        char[] cs2 = reverse(num2).toCharArray();
        int len2 = cs2.length;
        char[] cs = new char[len1 + len2];
        Arrays.fill(cs, '0');
        int addCarry, multiplyCarry;
        int temp1, temp2;
        for (int i = 0; i < len1; ++i) {
            addCarry = 0;
            multiplyCarry = 0;
            for (int j = 0; j < len2; ++j) {
                temp1 = (cs1[i] - '0') * (cs2[j] - '0') + multiplyCarry;
                multiplyCarry = temp1 / 10;
                temp2 = cs[i + j] - '0' + temp1 % 10 + addCarry;
                addCarry = temp2 / 10;
                cs[i + j] = (char) (temp2 % 10 + '0');
            }
            cs[i + len2] = (char) (cs[i + len2] + addCarry + multiplyCarry);
        }
        int end = cs.length - 1;
        while (end > 0 && cs[end] == '0') {
            --end;
        }
        return reverse(new String(cs, 0, end + 1));
    }

    private String reverse(String s) {
        if (s == null) {
            return null;
        }
        char[] cs = s.toCharArray();
        int begin = 0;
        int end = cs.length - 1;
        while (begin < end) {
            char temp = cs[begin];
            cs[begin] = cs[end];
            cs[end] = temp;
            ++begin;
            --end;
        }
        return new String(cs);
    }

}
