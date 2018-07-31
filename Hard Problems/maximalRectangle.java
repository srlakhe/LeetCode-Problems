class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int max = 0;
        int[] h = new int[n+1];
        for(int i = 0; i < m; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            for(int j = 0; j <= n; j++) {
                if(j < n)
                    if(matrix[i][j] == '1')
                        h[j] += 1;
                    else
                        h[j] = 0;
                if(stack.isEmpty() || h[j]>=h[stack.peek()])
                    stack.push(j);
                else {
                    while(!stack.isEmpty() && h[j] < h[stack.peek()]) {
                        int top = stack.pop();
                        int area = h[top] * (stack.isEmpty() ? j : (j - stack.peek() - 1));
                        if(area > max)
                            max = area;
                    }
                    stack.push(j);
                }
            }
        }
        return max;
    }
}
