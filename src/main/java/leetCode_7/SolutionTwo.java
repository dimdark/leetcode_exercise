package leetCode_7;

/**
 * @author dimdark
 * @date 2017-04-23
 * @time 10:07 AM
 */
public class SolutionTwo {

    public int reverse(int x){
        int y,preValue,tail;
        y = preValue = 0;
        while (x!=0){
            tail = x%10;
            y = y*10+tail;
            if((y-tail)/10!=preValue){
                return 0;
            }
            preValue = y;
            x = x/10;
        }
        return y;
    }

}
