package leetCode_8;

/**
 * @author dimdark
 * @date 2017-09-10
 * @time 10:58 AM
 */
public class Solution {

    public int myAtoi(String str) {
        if (str == null) return 0;
        int rst = 0, sign = 1, base = Integer.MAX_VALUE / 10;
        int i = 0, len = str.length();
        while (i < len && str.charAt(i) == ' ') i++;
        if (i >= len) return 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = (str.charAt(i++) == '-') ? -1 : 1;
        while (i < len && Character.isDigit(str.charAt(i))) {
            if (rst > base || (rst == base && str.charAt(i)-'0' > 7)) // wonderful
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            rst = rst * 10 + str.charAt(i++)-'0';
        }
        return rst * sign;
    }

}
