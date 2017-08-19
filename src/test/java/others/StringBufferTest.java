package others;

import org.junit.Test;

/**
 * @author dimdark
 * @date 2017-04-20
 * @time 6:12 PM
 */
public class StringBufferTest {


    @Test
    public void stringBufferTest(){
        StringBuffer buffer = new StringBuffer();
        buffer.append("I ");
        buffer.append("love ");
        buffer.append("you!");
        System.out.println(buffer.toString());
    }

    @Test
    public void test(){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE+1);
        System.out.println(Integer.MAX_VALUE+1-1);
        System.out.println(Integer.MIN_VALUE);
    }

}
