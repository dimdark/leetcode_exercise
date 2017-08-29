package leetCode_434;

/**
 * @author dimdark
 * @date 2017-08-29
 * @time 6:30 PM
 */
public class Solution {

    public int countSegments(String s) {
        if(s == null || s.length() == 0) return 0;
        int ans = 0, len = s.length();
        for(int i = 0; i < len; ++i) {
            if(i+1 < len && s.charAt(i) == ' ' && s.charAt(i+1) != ' ') ans++;
        }
        if(s.charAt(0) != ' ') ans++;
        return ans;
    }

}
