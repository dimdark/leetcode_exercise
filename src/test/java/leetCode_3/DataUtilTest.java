package leetCode_3;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author dimdark
 * @date 2017-04-19
 * @time 5:12 PM
 */
public class DataUtilTest {

    @Test
    public void randomStringTest(){
        String randomString = DataUtils.createRandomLetterString();
        System.out.println(randomString);
    }

    @Test
    public void arrayInitialTest(){
        int[] map = new int[256];
        Arrays.fill(map,-1);
        for(int element:map){
            System.out.println(element);
        }
    }

}
