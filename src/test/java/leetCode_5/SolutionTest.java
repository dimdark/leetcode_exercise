package leetCode_5;

import org.junit.Test;
import others.PalindromeStringUtil;
import others.RandomStringUtil;

/**
 * @author dimdark
 * @date 2017-04-20
 * @time 6:57 PM
 */
public class SolutionTest {

    @Test
    public void test(){
        Solution solution = new Solution();
        String s,ps;
        for (int i=0; i<10; ++i){
            s = PalindromeStringUtil.createPalindromeString();
            System.out.println(s);
            ps = solution.longestPalindrome(s);
            System.out.println(ps);
        }
    }

    @Test
    public void testTwo(){
        String s = "aaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaa";
        System.out.println(s);
        SolutionTwo solution = new SolutionTwo();
        String result = solution.longestPalindrome(s);
        System.out.println(result);
    }

}
