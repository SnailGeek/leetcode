package offer;

import com.sun.javafx.image.IntPixelGetter;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: BuildTree07
 * @description:
 * @author: wangf-q
 * @date: 2021-03-08 15:45
 **/
public class BuildTree07 {
    public static TreeNode buildTree(int[] preorder, int[] inorder) {



        for (int i = 0; i < preorder.length; i++) {
            List<Integer> left = new ArrayList<>();
            List<Integer> right = new ArrayList<>();
            int rootIndex = -1;
            for (int j = 0; j < inorder.length; j++) {
                if (preorder[i] == preorder[j]) {
                    rootIndex = j;
                }
                if (rootIndex == -1) {
                    left.add(inorder[j]);
                } else {
                    right.add(inorder[j]);
                }
            }
            TreeNode rootNode = new TreeNode(inorder[rootIndex]);

        }

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

