class Solution {
    public int longestSubstring(String s, int k) {
        return longestString(s.toCharArray(), k, 0, s.length());
    }
    
    int longestString(char[] s, int k, int start, int end) {
        
        if(end - start < k)
            return 0;
        int[] count = new int[26];
        
        for(int i = start; i < end; i++) {
            count[s[i] - 'a']++;    
        }
        
      
        for(int j = start; j < end; j++) {
            if (count[s[j] - 'a'] < k) {
                int i = j+1;
                while(i < end && count[s[i] - 'a'] < k)
                    i++;
                int len1 = longestString(s, k, start, j);
                int len2 = longestString(s, k, i, end);
                return Math.max(len1, len2);
            }
        }
        
        return end-start;
    }
}
