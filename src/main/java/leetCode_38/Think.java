package leetCode_38;

/**
 * @author dimdark
 * @date 2017-05-03
 * @time 1:05 PM
 */
public class Think {

    public String createNextNum(String num){
        StringBuffer nextNum = new StringBuffer();
        int i = 0,j,count = 1;
        int len = num.length();
        while (i<len){
            j = i+1;
            while (j<len && num.charAt(i)==num.charAt(j)){
                ++count;
                ++j;
            }
            nextNum.append(count);
            nextNum.append(num.charAt(i));
            count = 1;
            i = j;
        }
        return nextNum.toString();
    }

}
