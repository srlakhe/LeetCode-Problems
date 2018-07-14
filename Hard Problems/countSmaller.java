class Solution {
    class TreeNode {
        int val;
        int count;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        TreeNode root = null;
        int[] result = new int[nums.length];
        for(int i = nums.length-1; i >= 0; i--) {
           root = insertNode(root, nums[i], 0, result, i);
        }
        return IntStream.of(result).boxed().collect(Collectors.toList());
    }
    
    TreeNode insertNode(TreeNode root, int val, int count, int[] result, int i) {
        if(root == null) {
            root = new TreeNode(val);
            result[i] = count;
            return root;
        }
        if(val >= root.val) {
            root.right = insertNode(root.right, val, count + root.count +(val>root.val?1:0), result, i);
        } else {
            root.count = root.count + 1;
            root.left = insertNode(root.left, val, count, result, i);
        }
        return root;
    }
}
