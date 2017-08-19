package leetCode_1;

import java.util.HashMap;
import java.util.Map;

/**
 * leetCode提供了一种利用哈希表来查找与指定元素
 * 关联的索引，利用java的HashMap,查找的时间复杂度
 * 可以降至O(1)<br/>
 * @author dimdark
 * @date 2017-04-18
 * @time 7:02 PM
 */
public class Solution_2 {

    public int[] twoSum(int[] numbers, int target){
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();
        for (int i=0; i<numbers.length; ++i){
            if(map.containsKey(target-numbers[i])){
                return new int[] {map.get(target-numbers[i]),i};
            }
            map.put(numbers[i],i);
        }
        //找不到满足要求的元素
        throw new IllegalArgumentException("No two sum solution!");
    }

}
