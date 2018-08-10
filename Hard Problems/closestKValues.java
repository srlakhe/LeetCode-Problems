import java.util.*;
public class Solution {
    
    public List<Integer> closestKValues(TreeNode root, int target) {
        Stack<TreeNode> pred = new Stack<>();
        Stak<TreeNode> succ = new Stack<>();
        List<Integer> res = new ArrayList<>();
        inorder(root, pred, succ, target);
        
        for(int i = 0; i < k; i++) {
            if(pred.isEmpty()) {
                res.add(succ.pop());
            } else if(succ.isEmpty()) {
                res.add(pred.pop());
            } else if(Math.abs(target-pred.peek()) < Math.abs(target-succ.peek())) {
                res.add(pred.pop());
            } else
                res.add(succ.pop());
        }
        return res;
    } 
    
    void inorder(TreeNode root, Stack<TreeNode> pred, Stack<TreeNode> succ, int target) {
        if(root == null)
            return;
        inorder(root.left, pred, succ, target);
        if(root.val < target)
            pred.push(root.val);
        if(root.val >= target)
            succ.push(root.val);
        inorder(root.right, pred, succ, target);
    }

}
