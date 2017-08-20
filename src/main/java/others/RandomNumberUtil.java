package others;

import com.sun.org.apache.regexp.internal.RE;

import java.util.Random;

/**
 * @author dimdark
 * @date 2017-04-29
 * @time 3:54 PM
 */
public class RandomNumberUtil {

    private static final Random rand = new Random();

    private static final int NUMBER_QUANTITY = 15;

    private static final int MAX_VALUE = 100000000;

    public static int[] createRandomNumber(){
        int[] array = new int[NUMBER_QUANTITY];
        for (int i=0; i<array.length; ++i){
            array[i] = rand.nextInt(MAX_VALUE)+1;
        }
        return array;
    }

}
