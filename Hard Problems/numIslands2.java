import java.util.*;
public class Solution {
    
    private static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] root = new int[m*n];
        Arrays.fill(root, -1);
        
        List<Integer> result = new ArrayList<>();
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int count = 0;
        for(int[] position: positions) {
            count++;
            int index = position[0]*n+position[1];
            root[index] = index;
            for(int[] dir: dirs) {
                int x = position[0] + dir[0];
                int y = position[1] + dir[1];
                if(x >= 0 && x < m && y >= 0 && y < n && root[x*n+y] != -1) {
                    int curoot = getRoot(root, x*n+y);
                    if(curoot != index) {
                        root[curoot] = index;
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
    
    private static int getRoot(int[] root, int i) {
        while(root[i] != i) {
            i = root[i];
        }
        return i;
    }
     public static void main(String []args){
        int[][] grid = {{0,0}, {0,1}, {1,2}, {2,1}};
        List<Integer> res = numIslands2(3, 3, grid);
        for(int count: res)
            System.out.println(count);
     }
}
