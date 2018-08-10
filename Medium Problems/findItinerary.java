class Solution {
    
    HashMap<String, PriorityQueue<String>> graph;
    LinkedList<String> path;
    public List<String> findItinerary(String[][] tickets) {
        graph = new HashMap<>();
        path = new LinkedList<>();
        
        for(String[] t: tickets) {
            graph.putIfAbsent(t[0], new PriorityQueue<>());
            graph.get(t[0]).add(t[1]);
        }
        
        travel("JFK");
        return path;
    }
    
    void travel(String src) {
        PriorityQueue<String> dest = graph.get(src);
        
        while(dest != null && !dest.isEmpty())
            travel(dest.poll());
        path.addFirst(src);
    }
}
