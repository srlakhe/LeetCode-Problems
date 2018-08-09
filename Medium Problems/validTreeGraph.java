import java.util.*;
public class Solution {

    // dfs based approach
    public boolean isValid(int n, int[][] edges) {
        if(n-1 != edges.length)
            return false;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++)
            graph.put(i, new ArrayList<>());
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        dfs(graph, 0, visited, -1);
        for(boolean b: visited)
            if(!b)
                return false;
        return true;
    }
    
    boolean dfs(HashMap<Integer, List<Integer>> graph, int cur, boolean[] visited, int parent) {
        if(visited[cur])
            return false;
        visited[cur] = true;
        for(int next: graph.get(cur)) {
            if(next != parent && !dfs(graph, next, visited, cur))
                return false;
        }
        return true;
    }
    
    // bfs based apparoch
    public boolean isValid(int n, int[][] edges) {
        if(n-1 != edges.length)
            return false;
        HashMap<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++)
            graph.put(i, new ArrayListL<>());
        for(int[] edge: edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int node = queue.poll();
            if(visited[node])
                return false;
            visited[node] = true;
            for(int next: graph.get(node)) {
                if(!visited[next])
                    queue.offer(next);
            }
        }
        for(boolean b: visited)
            if(!b)
                return false;
    }

    // using union find algo
    public boolean isValid(int n, int[][] edges) {
        if(n-1 != edges.length)
            return false;
        int[] root = new int[n];
        for(int i = 0; i < n; i++)
            root[i] = i;
        for(int i = 0; i < n-1; i++) {
            int x = getRoot(edges[i][0]);
            int y = getRoot(edges[i][1]);
            if(x == y)
                return false;
            root[y] = x;
        }
        return true;
    }
    int getRoot(int[] root, int i) {
        while(root[i] != i) {
            root[i] = root[root[i]];
            i = root[i];
        }
        return i;
    }
    public static void main(String []args){
        List<String> list = findStobrogrammatic(3);
        for(String t: list)
            System.out.println(t);
        System.out.println(findStobrogrammaticInRange("666", "888"));
    }
}
