class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        if(m == 0)
            return 0;
        int lps[] = new int[m];
        computeLps(lps, needle, m);
        
        int i = 0, j = 0;
        while(i < n) {
            
            if(haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            }
            if(j == m)
                return i - j;
            if(i < n && haystack.charAt(i) != needle.charAt(j))
                if(j != 0)
                    j = lps[j-1];
                else
                    i++;   
        }
        return -1;
    }
    
    void computeLps(int[] lps, String needle, int m) {
        int j = 0;
        lps[0] = 0;
        int i = 1;
        while(i < m) {
            if(needle.charAt(i) == needle.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if(j != 0) {
                    j = lps[j-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }
}
