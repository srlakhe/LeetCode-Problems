public class HelloWorld{
    
    public int countComponents(int n, int[][] edges) {
        int[] root = new int[n];
        for(int i = 0; i < n; i++)
            root[i] = i;
        int count = n;
        for(int[] edge: edges) {
            int x = edges[0];
            int y = edges[1];
            int xroot = getRoot(root, x);
            int yroot = getRoot(root, y)l
            if(xroot != yroot) {
                count--;
                root[x] = yroot;
            }
        }
        return count;
    }
    
    public int getRoot(int[] root, int i) {
        while(root[i] != i) {
             root[i] = root[root[i]]
             i = root[i];
        }
           
        return i;
    }
}
