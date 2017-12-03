package theme.subset;

import java.util.Arrays;
import java.util.List;

/**
 * @author dimdark
 */
public class SubSetTest {

    public static void main(String[] args) {
//        int[] array = {6, 4, 3, 2};
//        Arrays.sort(array);
//        SubSetCreator creator = new SubSetCreator();
//        List<List<Integer>> results = creator.create(array);
//        for (List<Integer> result : results) {
//            System.out.println(result);
//        }
        int[] array1 = {2, 3, 3, 6};
        UniqueSubSetCreator creator1 = new UniqueSubSetCreator();
        List<List<Integer>> results1 = creator1.create(array1);
        for (List<Integer> result1 : results1) {
            System.out.println(result1);
        }
    }

}
