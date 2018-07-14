class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0)
            return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                int len = calculatePath(matrix, dp, i, j);
                System.out.println(len);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    int calculatePath(int[][] matrix, int[][] dp, int i, int j) {
        if(dp[i][j] > 0)
            return dp[i][j];
        int maxlen = 1;
        if(i+1 < matrix.length && matrix[i][j] < matrix[i+1][j])
            maxlen = Math.max(maxlen, 1 + calculatePath(matrix, dp, i+1, j));
        if(j+1 < matrix[0].length && matrix[i][j] < matrix[i][j+1])
           maxlen = Math.max(maxlen, 1 + calculatePath(matrix, dp, i, j+1));
        if(i-1 >= 0 && matrix[i][j] < matrix[i-1][j])
            maxlen = Math.max(maxlen, 1 + calculatePath(matrix, dp, i-1, j));
        if(j-1 >= 0 && matrix[i][j] < matrix[i][j-1])
            maxlen = Math.max(maxlen, 1 + calculatePath(matrix, dp, i, j-1));
        dp[i][j] = maxlen;
        return maxlen;
    }
    
}
