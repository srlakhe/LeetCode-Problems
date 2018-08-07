class Solution {
    public String removeDuplicateLetters(String s) {
        if(s.length() == 0)
            return "";
        int[] hmap = new int[26];
        int dup = 0;
        for(int i = 0; i < s.length(); i++) {
            hmap[s.charAt(i)-'a']++;
            if(hmap[s.charAt(i)-'a'] == 2)
                dup++;
        }
        if(dup == 0)
            return s;
        int imin = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hmap[ch-'a']--;
            if(ch < s.charAt(imin))
                imin = i;
            if(hmap[ch-'a'] == 0)
                break;
        }
        s = s.substring(imin);
        return s.substring(0, 1) + removeDuplicateLetters(s.substring(1).replaceAll(""+s.charAt(0), ""));
    }
}
