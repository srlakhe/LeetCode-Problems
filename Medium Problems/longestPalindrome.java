class Solution {
    public String longestPalindrome(String s) {
        String result = "";
        
        
        for(int i = 0; i < s.length(); i++) {
            String l1 = lp(s, i, i);
            if(l1.length() > result.length())
                result = l1;
            l1 = lp(s, i, i+1);
            if(l1.length() > result.length())
                result = l1;
        }
        
        return result;
    }
    
    String lp(String s, int i, int j) {
        while(i >= 0 && j < s.length()) {
            if(s.charAt(i) != s.charAt(j))
                break;
            i--;
            j++;
        }
        return s.substring(i+1, j);
    }
}
