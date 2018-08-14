class Solution {
    
    // DFS based solution
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] stack = new boolean[numCourses];
        
        
        List<Integer>[] graph = new ArrayList[numCourses];
        
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        for(int i = 0; i < prerequisites.length; i++) {
            int s = prerequisites[i][1];
            int e = prerequisites[i][0];
            
            graph[s].add(e);
        }
        
        for(int i = 0; i < numCourses; i++) {
            if(isCycle(graph, visited, stack, i))
                return false;
        }
        return true;
    }
    
    boolean isCycle(List<Integer>[] graph, boolean[] visited, boolean[] stack, int cur) {
        
        if(!visited[cur]) {
             visited[cur] = true;
             stack[cur] = true;
            
            for(int child: graph[cur]) {
                if(!visited[child] && isCycle(graph, visited, stack, child))
                    return true;
                else if (stack[child]) {
                    return true;
                }
            }
        }
        stack[cur] = false;
        return false;
    }
    
    // BFS Topological sort based solution
    List<Integer>[] graph;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++)
            graph[i] = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i = 0; i < prerequisites.length; i++) {
            int c = prerequisites[i][0];
            int p = prerequisites[i][1];
            graph[p].add(c);
            indegree[c]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++)
            if(indegree[i] == 0)
                queue.offer(i);
        int count = 0;
        while(!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for(int c: graph[course])
                if(--indegree[c] == 0)
                    queue.offer(c);
        }
        return count == numCourses;
    }
}
