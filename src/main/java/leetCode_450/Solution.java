package leetCode_450;

/**
 * @author dimdark
 * @date 2017-09-06
 * @time 10:41 PM
 */
public class Solution {

    public static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode[] findNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode node = root, fatherNode = null;
        while (node != null) {
            if (node.val == key) break;
            else if(node.val > key) {
                fatherNode = node;
                node = node.left;
            } else {
                fatherNode = node;
                node = node.right;
            }
        }
        return new TreeNode[]{fatherNode, node};
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode[] nodes = findNode(root, key);
        if (nodes == null || nodes[1] == null) return root; // key is not in the tree
        TreeNode fatherNode = nodes[0], node = nodes[1];
        // delete node
        if (node.left == null) {
            if (fatherNode == null) {
                root = node.right;
            } else {
                if (node == fatherNode.left) fatherNode.left = node.right;
                else fatherNode.right = node.right;
            }
        } else if(node.right == null) {
            if (fatherNode == null) {
                root = node.left;
            } else {
                if (node == fatherNode.left) fatherNode.left = node.left;
                else fatherNode.right = node.left;
            }
        } else {
            TreeNode preNode = node, successorNode = node.right;
            while (successorNode.left != null) {
                preNode = successorNode;
                successorNode = successorNode.left;
            }
            if(successorNode != node.right) {
                if (successorNode == preNode.left) preNode.left = successorNode.right;
                else preNode.right = successorNode.right;
                successorNode.right = node.right;
            }
            successorNode.left = node.left;
            if (fatherNode == null) {
                root = successorNode;
            } else {
                if (node == fatherNode.left) fatherNode.left = successorNode;
                else fatherNode.right = successorNode;
            }
        }
        return root;
    }

}
