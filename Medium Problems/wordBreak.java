class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        HashSet<String> words = new HashSet<>();
        for(String word : wordDict)
            words.add(word);
        
        boolean[] dp = new boolean[s.length()];
        
        for(int i = 0; i < s.length(); i++) {
            
    
            if(words.contains(s.substring(0, i+1))) {
                dp[i] = true;
            } else {
                 for(int j = i - 1; j >= 0; j--) {
                    if(dp[j] && words.contains(s.substring(j+1, i+1))) {
                        dp[i] = true;
                        break;
                    }
                        
                }
            }
           
        }
        return dp[s.length() - 1];
    }
}
