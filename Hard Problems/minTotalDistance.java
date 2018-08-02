public class Solution{

    public int minTotalDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        List<Integer> rows = new ArrayList<>();
        List<Integer> cols = new ArrayList<>();
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    cols.add(j);
                    rows.add(i);
                }
            }
        }
        
        int sum = 0;
        for(Integer i: rows) {
            sum += Math.abs(i - rows.get(rows.size()/2));
        }
        
        Collections.sort(cols);
        for(Integer i: cols) {
            sum += Math.abs(i - rows.get(rows.size()/2));
        }
        
        return sum;
    }
}
