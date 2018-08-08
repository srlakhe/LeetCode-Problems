public class Solution {
    
   static int MinSliceWeight(List<List<Integer>> Matrix) {
        int n = Matrix.size();
        int[] dp = new int[n];
        for(int i = 0; i < n; i++) {
            int[] temp = new int[n];
            for(int j = 0; j < n; j++) {
                if(i == 0)
                    temp[j] = matrix.get(i).get(j);
                else {
                    int temp[j] = dp[j];
                    if(j > 0)
                        temp[j] = Math.min(temp[j], dp[j-1]);
                    if(j < n-1)
                        temp[j] = Math.min(temp[j], dp[j+1]);
                    temp[j] += matrix.get(i).get(j);
                }
            }
            for(int k = 0; k < n; k++)
                dp[k] = temp[k];
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) 
            min = Math.min(dp[i], min);
        return min;

   }
}
