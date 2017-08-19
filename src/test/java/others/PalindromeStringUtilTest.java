package others;

import org.junit.Test;

/**
 * @author dimdark
 * @date 2017-04-20
 * @time 5:38 PM
 */
public class PalindromeStringUtilTest {

    @Test
    public void cratePalindromeStringTest(){
        String s = null;
        for(int i=0; i<10; ++i){
            s = PalindromeStringUtil.createPalindromeString();
            System.out.println(s);
        }
    }

}
