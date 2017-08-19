package leetCode_5;

/**
 * 暴力法O(n^2)寻找最长回文字符串<br/>
 * @author dimdark
 * @date 2017-04-20
 * @time 6:45 PM
 */
public class Solution {

    public String longestPalindrome(String s) {
        //最长回文子字符串的索引范围[longestStart,longestEnd]
        int longestStart =0,longestEnd=0;
        //以第i个字符为中心的最长回文子字符串的索引范围[oddStart,oddEnd]
        int oddStart,oddEnd;
        //以第i个字符和第i+1个字符的中间位置为中心的最长回文子字符串的索引范围[evenStart,evenEnd]
        int evenStart,evenEnd;
        //最长回文子字符串的长度
        int palindromeLength = 0;
        int length = s.length();
        for (int i=0; i<length; ++i){
            //初始化
            oddStart = oddEnd = i;
            evenStart=i+1; evenEnd=i;
            //确定不超过字符串的合理范围且对应位置的字符相等
            while (oddStart-1>-1 && oddEnd+1<length && s.charAt(oddStart-1)==s.charAt(oddEnd+1)){
                //更新回文字符串的索引范围
                oddStart--;
                oddEnd++;
            }
            while (evenStart-1>-1 && evenEnd+1<length && s.charAt(evenStart-1)==s.charAt(evenEnd+1)){
                evenStart--;
                evenEnd++;
            }
            if (palindromeLength<oddEnd-oddStart+1){
                palindromeLength = oddEnd-oddStart+1;
                longestStart = oddStart;
                longestEnd = oddEnd;
            }
            if (palindromeLength<evenEnd-evenStart+1){
                palindromeLength = evenEnd-evenStart+1;
                longestStart = evenStart;
                longestEnd = evenEnd;
            }
        }
        return s.substring(longestStart,longestEnd+1);
    }

}
