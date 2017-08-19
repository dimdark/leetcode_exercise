package leetCode_7;


/**
 * 利用更大的范围来处理小范围的溢出<br/>
 * @author dimdark
 * @date 2017-04-23
 * @time 10:27 AM
 */
public class SolutionThree {

    public int reverse(int x){
        long result = 0;
        while (x!=0){
            result = result*10+x%10;
            //handle int overflow case
            if(result>Integer.MAX_VALUE || result<Integer.MIN_VALUE){
                return 0;
            }
            x /= 10;
        }
        return (int)result;
    }

}
