import java.util.*;
public class Solution {
    
     // Method 1 using getNextPred and getNextSucc Methods
     public List<Integer> closestKValues(TreeNode root, int target) {
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
        List<Integer> res = new ArrayList<>();    
        TreeNode itr = root;
        while(itr != null) {
            if(itr.val <= target) {
                pred.push(itr);
                itr = itr.right;
            } else {
                succ.push(itr);
                itr = itr.left;
            }
        }
        
        while(k != 0) {
            if(succ.isEmpty() && pred.isEmpty())
                break;
            else if(pred.isEmpty()) {
                res.add(getNextSucc(succ));
            } else if(succ.isEmpty()) {
                res.add(getNextPred(pred));
            } else if(Math.abs(target-pred.peek()) <= Math.abs(target-succ.peek()) {
                res.add(getNextPred(pred));
            } else
                res.add(getNextSucc(succ));
            k--;
        }
       
        return res;
    }
    
    int getNextPred(Stack<TreeNode> pred) {
        int prev = pred.pop();
        TreeNode itr = prev.left;
        while(itr != null) {
            stack.push(itr);
            itr = itr.right;
        }
        return prev.val;
    }
    
    int getNextSucc(Stack<TreeNode> succ) {
        int prev = succ.pop();
        TreeNode itr = prev.right;
        while(itr != null) {
            stack.push(itr);
            itr = itr.left;
        }
    }
    
    // Method 2 using two stacks and inorder traversal
    public List<Integer> closestKValues(TreeNode root, int target) {
        Stack<TreeNode> pred = new Stack<>();
        Stack<TreeNode> succ = new Stack<>();
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
