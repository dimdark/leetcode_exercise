package theme.binarytree;

/**
 * @author dimdark
 * @date 2017-09-19
 * @time 9:00 PM
 */
public class BiTree<T extends Comparable<? super T>> {

    // 二叉树的根节点
    private BiTreeNode root;
    // 二叉树的节点个数
    private int nodeCount;

    /**
     * 利用前序遍历构建二叉树
     * @param values 二叉树按前序遍历输出节点的值(叶子节点的左右孩子的值规定为null)
     */
    public BiTree(T... values) {
        if (values == null || values.length == 0) {
            root = null;
            nodeCount = 0;
        } else {
            root = createBiTree(values); // after this operation, nodeCount is equal to values.length
        }
    }

    private BiTreeNode createBiTree(T[] values) {
        if (values[nodeCount] == null) {
            nodeCount++;
            return null;
        }
        BiTreeNode node = new BiTreeNode(values[nodeCount++]);
        node.left = createBiTree(values);
        node.right = createBiTree(values);
        return node;
    }

    // 二叉树的内部节点
    private class BiTreeNode {

        T value;
        BiTreeNode left;
        BiTreeNode right;

        BiTreeNode(T value) {
            this.value = value;
        }
        BiTreeNode(T value, BiTreeNode left, BiTreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }

    }

    public int getNodeCount() {
        return nodeCount;
    }

    

}
