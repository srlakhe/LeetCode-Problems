class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        
        int max = 0;
        int curr = 0;
        for(int i = 0; i < s.length(); i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0)+1);
            if(hmap.get(s.charAt(i)) == 2) {
                while(curr < i && hmap.get(s.charAt(i)) == 2) {
                    hmap.put(s.charAt(curr), hmap.get(s.charAt(curr)) - 1);
                    curr++;
                }
            } 
            max = Math.max(max, i - curr + 1);
        }
        return max;
    }
}
