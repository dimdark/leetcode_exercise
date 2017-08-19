package leetCode_7;



/**
 * @author dimdark
 * @date 2017-04-21
 * @time 6:34 PM
 */
public class Solution {
    public int reverse(int x) {
        if(x==Integer.MIN_VALUE){
            return 0;
        }
        boolean negative = (x<0)?true:false;
        int y;
        x = Math.abs(x);
        try {
            y = Integer.parseInt(new StringBuffer(String.valueOf(x)).reverse().toString());
        } catch (NumberFormatException e) {
            return 0;
        }
        if(negative){
            y = -y;
        }
        return y;
    }

    public static void main(String[] args) {
        int x = 100;
        Solution solution = new Solution();
        System.out.println(x);
        System.out.println(solution.reverse(x));
    }

}
