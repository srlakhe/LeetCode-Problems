class Solution {
    // Method 1: Using MaxHeap
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for(int[] b: buildings) {
            heights.add(new int[] {b[0], -b[2]});
            heights.add(new int[] {b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> {
            if(a[0] != b[0])
                return a[0]-b[0];
            return a[1]-b[1];
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.offer(0);
        int prev = 0;
        List<int[]> result = new ArrayList<>();
        for(int[] h: heights) {
            if(h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            if(pq.peek() != prev) {
                result.add(new int[] {h[0], cur});
                prev = pq.peek();
            }
        }
        return result;
    }
    
    // Method 2: Using modified merge sort
    public List<int[]> getSkyline(int[][] buildings) {
        return mergeSort(buildings, 0, buildings.length-1);
    }
    
    LinkedList<int[]> mergeSort(int[][] buildings, int lo, int hi) {
        LinkedList<int[]> res = new LinkedList<>();
        if(lo > hi)
            return res;
        else if(lo == hi) {
            res.add(new int[] {buildings[lo][0], buildings[lo][2]});
            res.add(new int[] {buildings[lo][1], 0});
            return res;
        }
        int mid = lo + (hi-lo)/2;
        LinkedList<int[]> left = mergeSort(buildings, lo, mid);
        LinkedList<int[]> right = mergeSort(buildings, mid+1, hi);
        int lefth = 0, righth = 0;
        while(!left.isEmpty() || !right.isEmpty()) {
            long x1 = left.isEmpty() ? Long.MAX_VALUE : left.peekFirst()[0];
            long x2 = right.isEmpty() ? Long.MAX_VALUE : right.peekFirst()[0];
            int x = 0;
            if(x1 < x2) {
                int[] temp = left.pollFirst();
                x = temp[0];
                lefth = temp[1];
            } else if(x1 > x2) {
                int[] temp = right.pollFirst();
                x = temp[0];
                righth = temp[1];
            } else {
                x = left.peekFirst()[0];
                lefth = left.pollFirst()[1];
                righth = right.pollFirst()[1];
            }
            int h = Math.max(lefth, righth);
            if(res.isEmpty() || h != res.peekLast()[1]) {
                res.add(new int[]{x, h});
            }
        }
        return res;
    }
}
