class Solution {
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
}
