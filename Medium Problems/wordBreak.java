class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hset = new HashSet<>();
        int max = 0;
        for(String word: wordDict) {
            hset.add(word);
            max = Math.max(max, word.length());
        }
        boolean[] dp = new boolean[s.length()];
 
        for(int i = 0; i < s.length(); i++) {
            if(hset.contains(s.substring(0, i+1)))
                dp[i] = true;
            else {
                for(int j = Math.max(0, i-max); j < i; j++)
                    if(dp[j] && hset.contains(s.substring(j+1, i+1)))
                        dp[i] = true;
            }
        }
        return dp[s.length()-1];
    }
}
