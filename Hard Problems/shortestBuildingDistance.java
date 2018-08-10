public class Solution{

    int[][] dist = new int[m][n];
    int[][] reached = new int[m][n];
    
    public int shortestDistance(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int numb = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    numb++;
                    bfshelper(grid, i, j);
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 0 && reached[i][j] == numb && dist[i][j]<res)
                    res = dist[i][j];
            }
        }
        return res;
    }
    
    void bfshelper(int[][] grid, int a, int b) {
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        Queue<Integer> queue = new LinkedList<>();
        int dis = 0;
        int m = grid.length;
        int n = grid[0].length;
        queue.offer(a*n+b);
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                int ind = queue.poll();
                int u = ind / n;
                int v = ind % n;
                reached[u][v]++;
                dist[u][v] += dis;
                for(int j = 0; j < 4; j++) {
                    int x = u + dirs[j][0];
                    int y = v + dirs[j][1];
                    if(x>=0 && x<m && y>=0 && y<n && grid[x][y]==0 && !visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(x*n+y);
                    }
                }
            }
            dis++;
        }
        
    }
}
