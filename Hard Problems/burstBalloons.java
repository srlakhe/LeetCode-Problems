class Solution {
    public int maxCoins(int[] nums) {
        int[] coins = new int[nums.length+2];
        int n = 1;
        for(int x: nums)
            if(x > 0)
                coins[n++] = x;
        coins[0] = coins[n++] = 1;
        int[][] maxcoins = new int[n][n];
        for(int dist = 2; dist < n; dist++) {
            for(int left = 0; left+dist<n; left++) {
                int right = left + dist;
                for(int i = left+1; i <= right-1; i++)
                    maxcoins[left][right] = Math.max(maxcoins[left][right], coins[left]*coins[i]*coins[right]+maxcoins[left][i]+maxcoins[i][right]);
            }
        }
        return maxcoins[0][n-1];
    }
}
