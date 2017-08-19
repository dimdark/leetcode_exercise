package leetCode_3;

/**
 * 这道题一开始自己觉得是用DP来解决的！但是思考一段时间后
 * 发现没有明确的递推关系[f(n)与f(n-1)的关系不明确]<br/>
 * 看了大牛的题解发现根本与DP没有关系，使用哈希表就可以解决了，
 * 看来数据结构是硬伤啊!<br/>
 * @author dimdark
 * @date 2017-04-19
 * @time 7:19 PM
 */
public class Solution {

    public int lengthOfLongestSubstring(String s){
        int[] map = new int[256];
        int start = 0, end, maxSubLen=0;
        for (end=0; end<s.length(); ++end){
            if(map[s.charAt(end)]!=-1){
                start = Math.max(start,map[s.charAt(end)]+1);
            }
            map[s.charAt(end)] = end;
            maxSubLen = Math.max(maxSubLen,end-start+1);
        }
        return maxSubLen;
    }

}
