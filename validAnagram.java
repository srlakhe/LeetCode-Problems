class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        char[] sarr = s.toCharArray();
        char[] tarr = t.toCharArray();
        for(int i = 0; i < sarr.length; i++) {
            hmap.put(sarr[i], hmap.getOrDefault(sarr[i], 0) + 1);
        }
        
        for(int i = 0; i < tarr.length; i++) {
            if(!hmap.containsKey(tarr[i]))
                return false;
            hmap.put(tarr[i], hmap.get(tarr[i]) - 1);
            if(hmap.get(tarr[i]) == 0)
                hmap.remove(tarr[i]);
        }
        return hmap.isEmpty();
    }
}
