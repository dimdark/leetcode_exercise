package theme.inversions_count;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import others.RandomNumberUtil;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author dimdark
 * @date 2017-04-29
 * @time 3:53 PM
 */
@RunWith(Parameterized.class)
public class InversionsCountTest {

    @Parameterized.Parameter(value = 0)
    public int[] array;

    private static final int DATA_QUANTITY = 100;

    @Parameterized.Parameters(name = "{index} : data{0}")
    public static Collection<int[]> data(){
        int[][] ds = new int[DATA_QUANTITY][];
        for (int i=0; i<ds.length; ++i){
            ds[i] = RandomNumberUtil.createRandomNumber();
        }
        return Arrays.asList(ds);
    }

    @Test
    public void inversionsTest(){
        int inversionsCount1 = InversionsCountOne.inversionsCount(array);
//        int inversionsCount2 = InversionsCountTwo.inversionsCount(array);
        int inversionsCount3 = InversionsCountThree.inversionsCount(array);
//        System.out.println(inversionsCount1);
//        System.out.println(inversionsCount3);
        Assert.assertEquals(inversionsCount1,inversionsCount3);
//        Assert.assertEquals(inversionsCount1,inversionsCount2);
    }


}
