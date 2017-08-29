package leetCode_434;

/**
 * @author dimdark
 * @date 2017-08-29
 * @time 6:44 PM
 */
public class SolutionTwo {

    public int countSegments(String s) {
        if(s == null) return 0;
        int ans = 0, i = 0, len = s.length();
        while(i < len) {
            if(s.charAt(i) != ' ') {
                ans++;
                while(i < len && s.charAt(i) != ' ') i++;
            }
            i++;
        }
        return ans;
    }

}
