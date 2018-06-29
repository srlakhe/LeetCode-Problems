class Solution {
    class Num {
        int row, col, val;
        Num(int r, int c, int v) {
            row = r;
            col = c;
            val = v;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Num> pq = new PriorityQueue<>(new Comparator<Num> () {
            public int compare(Num a, Num b) {
                return a.val - b.val;
            }
        });
        int n = matrix.length;
        for(int i = 0; i < n; i++) {
            Num t = new Num(0, i, matrix[0][i]);
            pq.add(t);
        }
        for(int i = 0; i < k-1; i++) {
            Num a = pq.poll();
            a.row = a.row + 1;
            if(a.row < n) {
                a.val = matrix[a.row][a.col];
                pq.add(a);
            }
        }
        return (pq.poll()).val;
    }
    
}
