package leetCode_516;

/**
 * 求最长回文字串
 * @author dimdark
 * @date 2017-09-19
 * @time 7:36 AM
 */
public class Solution {

    private char[] convert(char[] originChar) {
        char[] transChar = new char[(originChar.length<<1) + 1]; // 2n + 1
        int transLen = transChar.length;
        transChar[0] = '$';
        transChar[1] = originChar[0];
        transChar[transLen - 1] = '$';
        for (int i = 1; i < originChar.length; ++i) {
            transChar[i<<1] = '#';
            transChar[(i<<1) + 1] = originChar[i];
        }
        return transChar;
    }

    private void update(int[] p, char[] s) {
        // id = max(p[j] + j) i < j
        // mx = p[id] + id
        int id = 0, mx = 0;
        for (int i = 1; i < s.length - 1; ++i) {
            int j = (id<<1) - i;
            // mx - i > p[j] ---> p[i] = p[j]
            // mx - i <= p[j] ---> check s[mx + 1] == str[2i - mx - 1] is true
            // p[i] >= min(p[j], mx-i), mx > i
            p[i] = (mx > i) ? Integer.min(p[j], mx - i) : 0;
            while (s[i - p[i] - 1] != '$' && s[i + p[i] + 1] != '$' &&
                    s[i + p[i] + 1] == s[i - p[i] - 1]) ++p[i];
            if (i + p[i] > mx) {
                mx = i + p[i];
                id = i;
            }
        }
    }

    public int longestPalindromeSubseq(String s) {
        if (s == null || s == "") return 0;
        char[] originChar = s.toCharArray();
        char[] transChar = convert(originChar);
        int[] p = new int[transChar.length]; // auxiliary array
        update(p, transChar);
        int maxPalinLen = 1;
        for (int i = 1; i < transChar.length - 1; ++i) {
            maxPalinLen = (maxPalinLen < p[i] + 1) ? p[i] + 1 : maxPalinLen;
        }
        return maxPalinLen;
    }

//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        String s = "bbbab";
//        System.out.println(solution.longestPalindromeSubseq(s));
//    }

}
