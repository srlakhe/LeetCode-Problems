 
    public void wallsAndGates(int[][] rooms) {
        if(rooms.length == 0)
            return;
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms[0].length; j++) {
                if(rooms[i][j] == 0) {
                    bfs(rooms, i, j);
                }
            }
        }
    }
    
    void bfs(int[][] rooms, int i, int j) {
        Queue<Integer>queue = new LinkedList<>();
        queue.offer(i*rooms[0].length+j);
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        int dist = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int n = queue.poll();
                int b = n % rooms[0].length;
                int a = n / rooms[0].length;
                for(int l = 0; l < 4; l++) {
                    int x = a + dirs[l][0];
                    int y = b + dirs[l][1];
                    if(x>=0 && x<rooms.length && y>=0 && y<rooms[0].length&&!visited[x][y] && rooms[x][y] > dist+1) {
                        visited[x][y] = true;
                        rooms[x][y] = dist + 1;
                        queue.offer(x*rooms[0].length+y);
                    }
                }
            }
            dist++;
        }
    }
}
