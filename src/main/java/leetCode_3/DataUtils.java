package leetCode_3;

/**
 * @author dimdark
 * @date 2017-04-19
 * @time 5:04 PM
 */
public class DataUtils {

    //生成的随机字符串中包含的字母个数
    private static final int LETTERS_QUANTITY = 10;

    public static String createRandomLetterString(){
        StringBuffer randomString = new StringBuffer();
        char c;
        for(int i=0; i<LETTERS_QUANTITY; ++i){
            c = (char)(97 + (int)(Math.random()*26));
            randomString.append(c);
        }
        return randomString.toString();
    }


}
