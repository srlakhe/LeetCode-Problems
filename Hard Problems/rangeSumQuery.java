public class NumMatrix{

     private int[][] sum;
     
     public NumMatrix(int[][] matrix) {
         if(matrix == null || matrix.length == 0 || matrix[0].length == 0)
            return;
        int m = matrix.length;
        int n = matrix[0].length;
        sum = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            int row = 0;
            for(int j = 0; j < n; j++) {
              row += matrix[i][j];
              sum[i][j] = row;
              if(i != 0)
                sum[i][j] += sum[i-1][j];
            }
        }
     }
     
     public int sumRegion(int r1, int c1, int r2, int c2)  {
         if(sum == null)
            return 0;
        
        int res = 0;
        if(r1 == 0 && c1 == 0) {
            res = sum[r2][c2];
        } else if(r1 == 0) {
            res = sum[r2][c2] - sum[r2][c1-1];
        } else if(c1 == 0) {
            res = sum[r2][c2] - sum[r1-1][c2];
        } else {
            res = sum[r2][c2] - sum[r2][c1-1] - sum[r1-1][c2] + sum[r1-1][c1-1];
        }
        return res;
     }
     public static void main(String []args){
         int[][] matrix = {
              {3, 0, 1, 4, 2},
              {5, 6, 3, 2, 1},
              {1, 2, 0, 1, 5},
              {4, 1, 0, 1, 7},
              {1, 0, 3, 0, 5}
            };
        NumMatrix mat = new NumMatrix(matrix);
        System.out.println(mat.sumRegion(3, 0, 4, 4));
     }
}
