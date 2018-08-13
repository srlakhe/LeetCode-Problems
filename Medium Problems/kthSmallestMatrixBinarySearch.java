class Solution {
   
    public int kthSmallest(int[][] matrix, int k) {
       int l = matrix[0][0];
       int h = matrix[matrix.length-1][matrix[0].length-1];
      
       while(l < h) {
           int mid = l + (h-l)/2;
           int j = matrix[0].length-1;
            int count = 0;
           for(int i = 0; i < matrix.length; i++) {
               while(j >= 0 && matrix[i][j] > mid)
                   j--;
               count += (j+1);
           }
           if(count < k)
               l = mid + 1;
           else
               h = mid;
       }
       return l;
    }
    
}
