package leetCode_6;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import others.RandomStringUtil;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author dimdark
 * @date 2017-04-21
 * @time 4:15 PM
 */
@RunWith(Parameterized.class)
public class SolutionTest {

    @Parameterized.Parameter(value = 0)
    public String string;

    @Parameterized.Parameter(value = 1)
    public Integer rowsLength;

    @Parameterized.Parameters(name = "{index} : {0} {1}")
    public static Collection<Object[]> data(){
        int testTimes = 100;
        Object[][] o = new Object[testTimes+1][2];
        for (int i=0; i<o.length; ++i){
            o[i][0] = RandomStringUtil.createRandomString();
            o[i][1] = (int)(Math.random()*4+1);
        }
        return Arrays.asList(o);
    }

    @Test
    public void test(){
        Solution solution = new Solution();
        String result = solution.convert(string,rowsLength);
        System.out.println(string + " " + rowsLength);
        System.out.println(result);
    }

}
