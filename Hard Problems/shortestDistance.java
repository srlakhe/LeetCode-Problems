import java.util.*;
public class Solution {
    
    private static int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] buildings = new int[m][n];
        int[][] distances = new int[m][n];
        
        int nbuildings = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    nbuildings++;
                    bfs(grid, i, j, buildings, distances);
                }
            }
        }
        
        int mindist = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && buildings[i][j] == nbuildings && distances[i][j] != 0) {
                    mindist = Math.min(mindist, distances[i][j]);
                }
            }
        }
        return mindist;
    }
    
    static void bfs(int[][] grid, int i, int j, int[][] buildings, int[][] distances) {
        
        Queue<Integer> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        queue.offer(i*n+j);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            int len = queue.size();
            for(int k = 0; k < len; k++) {
                int temp = queue.poll();
                int tempi = temp / n;
                int tempj = temp % n;
                for(int[] dir: dirs) {
                    int x = dir[0] + tempi;
                    int y = dir[1] + tempj;
                    if(x >= 0 && x < m && y >= 0 && y < n && !visited[x][y] && grid[x][y] == 0) {
                        visited[x][y] = true;
                        distances[x][y] += level;
                        buildings[x][y]++;
                        queue.offer(n*x+y);
                    }
                }
            }
        }
    }
     public static void main(String []args){
        int[][] grid = {{1, 0, 2, 0, 1},
            {1, 0, 0, 0, 0},
            {1, 0, 1, 0, 0}};
        System.out.println(shortestDistance(grid));
     }
}
