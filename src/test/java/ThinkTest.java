import org.junit.Test;
import theme.inversions_count.InversionsCountThree;

/**
 * @author dimdark
 * @date 2017-04-30
 * @time 10:54 AM
 */
public class ThinkTest {

    @Test
    public void test(){
        int[] a = {7, -90, 100, 1};
        System.out.println(InversionsCountThree.inversionsCount(a));
    }

}
