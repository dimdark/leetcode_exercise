package others;

/**
 * @author dimdark
 * @date 2017-04-21
 * @time 4:15 PM
 */
public class RandomStringUtil {

    /**
     * 产生随机长度的字符串<br/>
     * @return String对象
     */
    public static String createRandomString(){
        StringBuffer buffer = new StringBuffer();
        int length = (int)(Math.random()*20+1);
        char c;
        for (int i=0; i<length; ++i){
            c = (char)(97+(int)(Math.random()*26));
            buffer.append(c);
        }
        return buffer.toString();
    }

}
