class Solution {
    public int kEmptySlots(int[] flowers, int k) {
        TreeSet<Integer> treeset = new TreeSet<>();
        for(int i = 0; i < flowers.length; i++) {
            int cur = flowers[i];
            Integer next = treeset.higher(cur);
            if(next != null && next - cur == k+1)
                return i+1;
            Integer pre = treeset.lower(cur);
            if(pre != null && cur-pre == k+1)
                return i+1;
            treeset.add(cur);
        }
        return -1;
    }
}
