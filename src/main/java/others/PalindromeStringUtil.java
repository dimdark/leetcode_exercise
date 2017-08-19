package others;

/**
 * @author dimdark
 * @date 2017-04-20
 * @time 5:30 PM
 */
public class PalindromeStringUtil {

    /**
     * 产生一串回文字符串,字符串的长度范围为[1,21)<br/>
     * @return String 回文字符串
     */
    public static String createPalindromeString(){
        int length = (int)(Math.random()*20+1);
        StringBuffer buffer = new StringBuffer();
        char c;
        for (int i=0; i<length/2; ++i){
            c = (char)(97+(int)(Math.random()*26));
            buffer.append(c);
        }
        //这两句是有区别的!
//        String endString = buffer.reverse().toString();
        String endString = new StringBuffer(buffer.toString()).reverse().toString();
        if((length&1)==1){
            c = (char)(97+(int)(Math.random()*26));
            buffer.append(c);
        }
        buffer.append(endString);
        return buffer.toString();
    }

}
