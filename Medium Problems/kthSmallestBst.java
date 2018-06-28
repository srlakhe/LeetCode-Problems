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
        private static int num = 0;
        private static int ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        ans = 0;
        num = 0;
        inorder(root, k);
        return ans;
    }
    
    public void inorder(TreeNode root, int k) {
        if(root == null)
            return;
       if(root.left != null)
           inorder(root.left, k);
        num = num + 1;
        if(num == k)
           ans = root.val;
        if(root.right != null)
            inorder(root.right, k);
    }
}
