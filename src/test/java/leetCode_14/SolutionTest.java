package leetCode_14;

import org.junit.Test;

/**
 * @author dimdark
 * @date 2017-05-02
 * @time 11:01 PM
 */
public class SolutionTest {

    @Test
    public void test(){
        Solution solution = new Solution();
        String[] s = new String[]{
                "ca","a"
        };
        System.out.println(solution.longestCommonPrefix(s));
    }

}
