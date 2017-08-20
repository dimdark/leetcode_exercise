package leetCode_423;

/**
 * 思路: 0-9这10个数字中偶数数字都可以用唯一的字母来区分<br/>
 * 可以用'z'来表示,同理, 2 4 6 8 可以分别用'w' 'u' 'x' 'g' 来表示<br/>
 * 剩下的奇数数字的个数可利用偶数数字的个数和其余字母的个数来计算<br/>
 * @author dimdark
 * @date 2017-08-19
 * @time 10:26 PM
 */
public class Solution {

    public String originalDigits(String s) {
        int[] digits = new int[10];
        int oCount, tCount, fCount, vCount, iCount;
        oCount = tCount = fCount = vCount = iCount = 0;
        for(char c : s.toCharArray()) {
            if(c == 'z') digits[0]++;
            if(c == 'w') digits[2]++;
            if(c == 'u') digits[4]++;
            if(c == 'x') digits[6]++;
            if(c == 'g') digits[8]++;
            if(c == 'o') oCount++;
            if(c == 't') tCount++;
            if(c == 'f') fCount++;
            if(c == 'v') vCount++;
            if(c == 'i') iCount++;
        }
        digits[1] = oCount - digits[0] - digits[2] - digits[4];
        digits[3] = tCount - digits[2] -digits[8];
        digits[5] = fCount - digits[4];
        digits[7] = vCount - digits[5];
        digits[9] = iCount - digits[5] - digits[6] - digits[8];
        StringBuilder rst = new StringBuilder();
        for(int i=0; i<10; ++i) {
            while(digits[i] != 0) {
                rst.append(i);
                digits[i]--;
            }
        }
        return rst.toString();
    }

}
