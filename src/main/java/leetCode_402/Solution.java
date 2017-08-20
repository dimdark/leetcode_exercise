package leetCode_402;

/**
 * @author dimdark
 * @date 2017-08-20
 * @time 10:39 AM
 */
public class Solution {

    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        if(k == 0) return num;
        num = num + "0";
        char[] cs = num.toCharArray();
        int[] flag = new int[num.length()-1];
        boolean end = false;
        for(int i=1; i<cs.length; ++i) {
            for(int j=i-1; j>=0; --j) {
                if(cs[j] > cs[i] && flag[j]!= 1) {
                    if(k != 0) {
                        flag[j] = 1;k--;
                    }
                }
                if(k == 0) {
                    end = true; break;
                }
            }
            if(end) break;
        }
        StringBuilder rst = new StringBuilder();
        boolean leadZero = true;
        for(int i=0; i<cs.length-1; ++i) {
            if(flag[i] != 1) {
                if(cs[i] != '0') leadZero = false;
                if(!leadZero) rst.append(cs[i]);
            }
        }
        if(rst.toString().equals("")) rst.append('0');
        return rst.toString();
    }

}
