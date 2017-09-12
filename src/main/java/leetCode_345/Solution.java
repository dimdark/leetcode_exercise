package leetCode_345;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author dimdark
 * @date 2017-09-12
 * @time 9:15 PM
 */
public class Solution {

    private HashSet<Character> createVowelSet() {
        HashSet<Character> vowels = new HashSet<Character>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }

    public String reverseVowels(String s) {
        if (s == null) return null;
        HashSet<Character> vowels = createVowelSet();
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;
        while (i < j) {
            while (i < j && !vowels.contains(Character.toLowerCase(chars[i]))) {
                i++;
            }
            while (i < j && !vowels.contains(Character.toLowerCase(chars[j]))) {
                j--;
            }
            if (i >= j) break;
            char tmpChar = chars[i];
            chars[i] = chars[j];
            chars[j] = tmpChar;
            i++; j--;
        }
        return String.valueOf(chars);
    }

}
