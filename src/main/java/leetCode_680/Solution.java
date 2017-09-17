package leetCode_680;

/**
 * @author dimdark
 * @date 2017-09-17
 * @time 3:58 PM
 */
public class Solution {

    private boolean isPalindromeRange(String s, int lIdx, int rIdx) {
        for (int i = lIdx; i <= (lIdx+rIdx) / 2; ++i) {
            if (s.charAt(i) != s.charAt(lIdx + rIdx - i)) return false;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; ++i) {
            int j = len - 1 - i;
            if (s.charAt(i) != s.charAt(j)) {
                return isPalindromeRange(s, i + 1, j) || isPalindromeRange(s, i, j - 1);
            }
        }
        return true;
    }

}
