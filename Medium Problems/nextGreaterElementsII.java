class Solution {
    // method1: by iterating over the same array twice
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n * 2; i++) {
            int num = nums[i%n];
            while(!stack.isEmpty() && nums[stack.peek()]<num) {
                res[stack.pop()] = num;
            }
            if(i < n)
                stack.push(i);
        }
        return res;
    }
    
    // method2: by initially storing the indices on the stack
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = n-1; i >= 0; i--)
            stack.push(i);
        
        for(int i = n-1; i >= 0; i--) {
            while(!stack.isEmpty() && nums[stack.peek()]<=nums[i])
                stack.pop();
            if(!stack.isEmpty()) {
                res[i] = nums[stack.peek()];
            }
            stack.push(i);
        }
        return res;
    }
}
