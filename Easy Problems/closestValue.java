import java.util.*;
public class Solution {
    
    double res;
    double min = Double.MAX_VALUE;
    public double closestValue(TreeNode root, double target) {
        dfs(root, target);
        return res;
    }
    
    double dfs(TreeNode root, double target) {
        if(root == null)
            return;
            
        if(Math.abs(target-root.val)<min) {
            min = Math.abs(target-root.val);
            res = root.val;
        }
        if(target < root.val)
            dfs(root.left, target);
        else
            dfs(root.right, target);
    }
}
