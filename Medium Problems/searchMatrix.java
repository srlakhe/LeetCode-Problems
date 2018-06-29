class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0)
            return false;
        int i = 0, j = matrix[0].length-1;
        
        while(i < m && j >= 0) {
            if(matrix[i][j] > target)
                j--;
            else if(matrix[i][j] < target)
                i++;
            else
                return true;
        }
        return false;
    }
}
