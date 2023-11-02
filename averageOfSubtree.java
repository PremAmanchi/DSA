/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Solution {
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        int[] result = helper(root);
        return count ;
    }

    private int[] helper(TreeNode root) {
        int[] result = new int[2]; // result[0] = sum ; result[1] = number of children
        // base case;
        if (root == null) {
            return result;
        }

        // logic
        int[] left = helper(root.left);
        int[] right = helper(root.right);

        result[0] = left[0] + right[0] + root.val;
        result[1] = left[1] + right[1] + 1;

        if (root.val == result[0] / result[1])
            count++;

        return result;
    }
}
