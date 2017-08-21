package leetCode_412;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dimdark
 * @date 2017-08-21
 * @time 9:32 PM
 */
public class Solution {

    public List<String> fizzBuzz(int n) {
        List<String> rst = new ArrayList<String>();
        for(int i = 1; i <= n; ++i) {
            if(i % 15 == 0) {
                rst.add("FizzBuzz");
            }else if(i % 5 == 0) {
                rst.add("Buzz");
            }else if(i % 3 == 0) {
                rst.add("Fizz");
            }else {
                rst.add(String.valueOf(i));
            }
        }
        return rst;
    }

}
