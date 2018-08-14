public class Solution{

    // iterative solution
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while(root != null) {
            if(root.val > p.val) {
                res = root;
                root = root.left;
            } else 
                root = root.right;
        }
        return res;
    }
    
    // recursive solution
    TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null)
            return null;
        if(root.val > p.val) {
            TreeNode node = inorderSuccessor(root.left, p);
            return node == null ? root : node;
        } else
            return inorderSuccessor(root.right, p);
    }        
}
