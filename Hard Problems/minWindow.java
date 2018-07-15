class Solution {
    public String minWindow(String s, String t) {
        
        int count = t.length(), start = 0;
        int[] hmap = new int[256];
        for(char ch: t.toCharArray())
           hmap[ch] = hmap[ch]+1;
        int min = Integer.MAX_VALUE;
        int sindex = 0;
        for(int i = 0; i < s.length(); i++) {
           if(hmap[s.charAt(i)] > 0)
               count--;
            hmap[s.charAt(i)]--;
            while(count == 0) {
                if(i-start+1 < min) {
                    min = i - start+1;
                    sindex = start;
                }
                if(hmap[s.charAt(start)] == 0)
                    count++;
                hmap[s.charAt(start)]++;
                start++;
            }
        }
        return min==Integer.MAX_VALUE ? "" : s.substring(sindex, sindex+min);
    }
}
