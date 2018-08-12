class Solution {
    // Solution to Unique Paths 1
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++)
            dp[i][0] = 1;
         for(int i = 0; i < n; i++)
            dp[0][i] = 1;
        
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++)
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
        }
        return dp[m-1][n-1];
    }
    
    // Solution to Unique Paths 2
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i != 0 && obstacleGrid[i][j] != 1)
                    dp[i][j] += dp[i-1][j];
                if(j != 0 && obstacleGrid[i][j] != 1)
                    dp[i][j] += dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
