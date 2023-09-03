// problem link : https://leetcode.com/problems/maximum-binary-tree-ii/description/
// tc  : O(height);
// sc : O(1);

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
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // base case
        if(root == null)
            return new TreeNode(val);
        // logic
        if(root.val < val){
            TreeNode curr = new TreeNode(val);
            curr.left = root;
            return curr;
        }
        root.right = insertIntoMaxTree(root.right, val);
        return root;
    }
}