package leetCode_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author dimdark
 */
public class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<List<String>>();
        }
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        int[] letters = new int[26];
        Arrays.fill(letters, 0);
        for (String s : strs) {
            // char[] cs = s.toCharArray();
            for (char c : s.toCharArray()) {
                ++letters[c - 'a'];
            }
            StringBuilder builder = new StringBuilder();
            for (int letter : letters) {
                builder.append(letter).append('!');
            }
            String string = builder.toString();
            if (map.containsKey(string)) {
                map.get(string).add(s);
            } else {
                List<String> list = new ArrayList<String>();
                list.add(s);
                map.put(string, list);
            }
            Arrays.fill(letters, 0);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
