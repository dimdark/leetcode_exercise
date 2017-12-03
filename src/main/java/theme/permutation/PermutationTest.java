package theme.permutation;

import java.util.List;

/**
 * @author dimdark
 */
public class PermutationTest {

    public static void main(String[] args) {
//        int[] array1 = {1, 2, 3};
//        PermutationCreator creator1 = new PermutationCreator();
//        List<List<Integer>> results1 = creator1.permute(array1);
//        for (List<Integer> result : results1) {
//            System.out.println(result);
//        }
        int[] array2 = {1, 2, 2};
        UniquePermutationCreator creator2 = new UniquePermutationCreator();
        List<List<Integer>> results2 = creator2.permute(array2);
        for (List<Integer> result : results2) {
            System.out.println(result);
        }
    }

}
