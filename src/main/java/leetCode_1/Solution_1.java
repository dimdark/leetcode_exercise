package leetCode_1;


/**
 * 暴力法:确定满足要求的第一个元素然后搜索要寻找的另一个
 * 元素<br/>
 * @author dimdark
 * @date 2017-04-18
 * @time 6:44 PM
 */
public class Solution_1 {

    public int[] twoSum(int[] numbers, int target){
        for (int i=0; i<numbers.length; ++i){
            for (int j=i+1; j<numbers.length; ++j){
                if(numbers[i]+numbers[j]==target){
                    return new int[] {i,j}; // 这一步很巧妙，可以学习
                }
            }
        }
        //找不到满足要求的两个元素
        throw new IllegalArgumentException("No two sum solution!");
    }

}
