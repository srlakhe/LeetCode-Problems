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
    int result;
    public int maxPathSum(TreeNode root) {
        result = Integer.MIN_VALUE;
        pathSum(root);
        return result;
    }
    
    int pathSum(TreeNode root) {
        if(root == null)
            return 0;
        int left = Math.max(0, pathSum(root.left));
        int right = Math.max(0, pathSum(root.right));
        result = Math.max(result, left+right+root.val);
        return Math.max(left, right)+root.val;
    }
}
