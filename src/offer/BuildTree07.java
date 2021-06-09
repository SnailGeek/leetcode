package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: BuildTree07
 * @description:
 * @author: wangf-q
 * @date: 2021-03-08 15:45
 **/
public class BuildTree07 {
    private Map<Integer, Integer> indexMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            indexMap.put(inorder[i], i);
        }
        int n = preorder.length;
        return doBuildTree(preorder, inorder, 0, n - 1, 0, n - 1);
    }

    public TreeNode doBuildTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
        if (inStart < inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        Integer rootIndex = indexMap.get(preorder[preStart]);
        int leftNodeCount = rootIndex - inStart;
        root.left = doBuildTree(preorder, inorder, preStart + 1, preStart + leftNodeCount, inStart, rootIndex - 1);
        root.right = doBuildTree(preorder, inorder, preStart + leftNodeCount + 1, preEnd, rootIndex + 1, inEnd);
        return root;
    }


}


// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

