package leetCode_5;


/**
 * manacher算法找最长回文子字符串<br/>
 * @author dimdark
 * @date 2017-04-22
 * @time 11:39 PM
 */
public class SolutionTwo {

    public String longestPalindrome(String s) {
        char[] oriChars = s.toCharArray();
        char[] chars = new char[oriChars.length*2+1];
        //p[j]的值等于以j为中心的最长回文子字符串的右边界的索引减去j
        int[] p = new int[chars.length];
        //id等于对于任意j<i,p[j]+j取得最大值时的j
        //mx = p[id] + id
        int id,i,j,mx;
        //完成转换: aba ------> #a#b#a#
        chars[0] = '#';
        for (i=0; i<oriChars.length; ++i){
            chars[2*i+1] = oriChars[i];
            chars[2*i+2] = '#';
        }
        //更新数组p的值
        id = mx = 0;
        p[id] = 0;
        for (i=1; i<chars.length; ++i){
            j = 2*id-i;
            p[i] = (i>mx)?0:Math.min(mx-i,p[j]);
            while (i-p[i]-1>-1 && i+p[i]+1<chars.length && chars[i+p[i]+1]==chars[i-p[i]-1]){
                p[i]++;
            }
            //更新id和mx
            if(mx<p[i]+i){
                id = i;
                mx = p[i]+i;
            }
        }

        System.out.println(String.valueOf(chars));
        for (int v:p){
            System.out.printf("%d ",v);
        }
        System.out.println();

        //maxLen为转换后的字符串的最长子字符串的长度/2
        //maxIndex为转换后的字符串的最长子字符串的中心元素的索引
        int maxLen = 0, maxIndex = 0;
        for (i=1; i<p.length-1; ++i){
            if (p[i]>maxLen){
                maxLen = p[i];
                maxIndex = i;
            }
        }
        //转换为原始的字符串的最长子字符串
        //oriStartIndex为原始字符串中最长子字符串的开始索引
        maxLen = (chars[maxIndex-maxLen]=='#')?maxLen-1:maxLen;
        int oriStartIndex = (maxIndex-maxLen)/2;
        //以下可以等价于:
        //return s.substring(oriStartIndex,oriStartIndex+maxLen+1);
        char[] subChars = new char[maxLen+1];
        for (i=0; i<subChars.length; ++i){
            subChars[i] = oriChars[oriStartIndex++];
        }
        return String.valueOf(subChars);
    }

}
