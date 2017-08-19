package leetCode_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dimdark
 * @date 2017-04-21
 * @time 3:51 PM
 */
public class Solution {

    public String convert(String s, int rowsLength) {
        if (rowsLength==1){
            return s;
        }
        Map<Integer,ArrayList<Character>> map = new HashMap<Integer,ArrayList<Character>>();
        //初始化map
        for (int i=0; i<rowsLength; ++i){
            map.put(i,new ArrayList<Character>());
        }
        //flag为true表示index递增(向下移动),为false表示index递减(向上移动)
        boolean flag = true;
        int index = 0; //用来取得对应行数的字符数组
        for (int i=0; i<s.length(); ++i){
            ArrayList<Character> chars = map.get(index);
            chars.add(s.charAt(i));
            index = flag?(index+1):(index-1);
            if(index==rowsLength){
                index -= 2;
                flag = false;
            }
            if (index==-1){
                index += 2;
                flag = true;
            }
        }
        //将结果转换为字符串
        StringBuffer buffer = new StringBuffer();
        for (int i=0; i<rowsLength; ++i){
            ArrayList<Character> chars = map.get(i);
            for (char c:chars){
                buffer.append(c);
            }
        }
        return buffer.toString();
    }

}
