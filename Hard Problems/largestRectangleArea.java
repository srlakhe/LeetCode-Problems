class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxarea = 0;
        for(int i = 0; i <= heights.length; i++) {
            int h = (i == heights.length) ? 0 : heights[i];
            if(stack.isEmpty() || h >= heights[stack.peek()])
                stack.push(i);
            else {
                int nexti = stack.pop();
                int curarea = heights[nexti] * (stack.isEmpty() ? i: i-1-stack.peek());
                maxarea = Math.max(maxarea, curarea);
                i--;
            }
        }
        return maxarea;
    }
}
