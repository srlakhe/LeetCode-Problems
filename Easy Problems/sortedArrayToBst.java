/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }
    
    TreeNode buildTree(int[] nums, int start, int end) {
        if(start >= end)
            return null;
        int mid = (start + end) / 2;
        
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, start, mid);
        root.right = buildTree(nums, mid+1, end);
            
        return root;
    }
}
