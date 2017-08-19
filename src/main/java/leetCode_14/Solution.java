package leetCode_14;

/**
 * @author dimdark
 * @date 2017-05-02
 * @time 11:00 PM
 */
public class Solution {

    public String longestCommonPrefix(String[] s) {
        if(s==null || s.length==0){
            return "";
        }
        int minLen=s[0].length(),minIndex=0;
        for(int i=1; i<s.length; ++i){
            if(minLen>s[i].length()){
                minLen = s[i].length();
                minIndex = i;
            }
        }
        String result = s[minIndex];
        for(int i=0; i<s.length; ++i){
            while(s[i].indexOf(result)!=0){ //not the common prefix
                result = result.substring(0,result.length()-1);
            }
            if(result.length()==0) break;
        }
        return result.toString();
    }

}
