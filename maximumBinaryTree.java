// problem link : https://leetcode.com/problems/maximum-binary-tree/
// tc : O(n*n)
// sc : O(n)


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
 class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        // base case
        if (left > right)
            return null;

        int maxIndex = findMaxIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxIndex]);

        root.left = buildTree(nums, left, maxIndex - 1);
        root.right = buildTree(nums, maxIndex + 1, right);
        return root;
    }

    private int findMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for (int i = left + 1; i <= right; i++)
            if (nums[i] > nums[maxIndex]) 
                maxIndex = i;
        return maxIndex;
    }
}