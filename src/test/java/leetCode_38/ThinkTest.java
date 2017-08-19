package leetCode_38;

import org.junit.Test;

/**
 * @author dimdark
 * @date 2017-05-03
 * @time 1:15 PM
 */
public class ThinkTest {

    @Test
    public void test(){
        Think think = new Think();
        String num = "1";
        System.out.println(num);
        for (int i=0; i<10; ++i){
            num = think.createNextNum(num);
            System.out.println(num);
        }
    }


}
