package leetCode_30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author dimdark
 */
public class Solution {

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<Integer>();
        if (s == null || words == null || s.length() == 0 ||
                words.length == 0 || words[0].length() == 0) {
            return results;
        }
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        int length = s.length();
        int wordNumber = words.length;
        int wordLength = words[0].length();
        for (int i = 0; i < wordLength; ++i) {
            int leftBound = i;
            int count = 0;
            HashMap<String, Integer> tmpMap = new HashMap<String, Integer>();
            for (int j = i; j <= length - wordLength; j += wordLength) {
                String word = s.substring(j, j + wordLength);
                if (map.containsKey(word)) {
                    if (tmpMap.containsKey(word)) {
                        tmpMap.put(word, tmpMap.get(word) + 1);
                    } else {
                        tmpMap.put(word, 1);
                    }
                    if (tmpMap.get(word) <= map.get(word)) {
                        ++count; // is valid word
                    } else {
                        while (tmpMap.get(word) > map.get(word)) {
                            String string = s.substring(leftBound, leftBound + wordLength);
                            if (tmpMap.get(string) <= map.get(string)) {
                                --count;
                            }
                            tmpMap.put(string, tmpMap.get(string) - 1);
                            leftBound += wordLength;
                        }
                    }
                } else {
                    tmpMap.clear();
                    count = 0;
                    leftBound = j + wordLength;
                }
                if (count == wordNumber) {
                    results.add(leftBound);
                    String string = s.substring(leftBound, leftBound + wordLength);
                    tmpMap.put(string, tmpMap.get(string) - 1);
                    --count;
                    leftBound += wordLength;
                }
            }
        }
        return results;
    }

}
