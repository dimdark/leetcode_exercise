package theme.fenwicktree;

import org.junit.Test;

/**
 * @author dimdark
 * @date 2017-04-29
 * @time 7:53 PM
 */
public class FenwickTreeTest {

    @Test
    public void test(){
        int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        FenwickTree tree = new FenwickTree(a);
        tree.add(1,5);
        tree.add(6,5);
        tree.add(15,5);
        System.out.println(tree.query(0,a.length));
    }

}
