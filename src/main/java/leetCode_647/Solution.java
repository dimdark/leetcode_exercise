package leetCode_647;

/**
 * @author dimdark
 * @date 2017-09-24
 * @time 7:18 PM
 */
public class Solution {

    private int count = 1; // notice count is initialize as 1

    private void palindromicStringCount(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            ++count;
            --start; ++end;
        }
    }

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int len = s.length();
        for (int i = 0; i < len - 1; ++i) {
            palindromicStringCount(s, i, i);
            palindromicStringCount(s, i, i + 1);
        }
        return count;
    }

}
