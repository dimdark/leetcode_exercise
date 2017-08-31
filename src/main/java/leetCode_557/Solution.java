package leetCode_557;

/**
 * @author dimdark
 * @date 2017-08-29
 * @time 11:15 PM
 */
public class Solution {

    public String reverseWords(String s) {
        if(s == " ") return " ";
        StringBuilder rst = new StringBuilder();
        String[] words = s.split("\\s");
        String tmp;
        for(int i = 0; i < words.length; ++i) {
            tmp = (new StringBuilder(words[i])).reverse().toString();
            rst.append(tmp);
            if(i != words.length-1) rst.append(" ");
        }
        return rst.toString();
    }

}
