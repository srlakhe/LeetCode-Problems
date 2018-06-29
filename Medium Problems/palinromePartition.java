class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(result, new ArrayList<String>(), s, 0);
        return result;
    }
    
    void backtrack(List<List<String>> result, List<String> temp, String s, int start) {
        if(start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = start; i < s.length(); i++) {
            if(isPalindrome(s.substring(start, i+1))) {
                temp.add(s.substring(start, i+1));
                backtrack(result, temp, s, i+1);
                temp.remove(temp.size() - 1); 
            }
        }
    }
    
    boolean isPalindrome(String s) {
        for(int i = 0, j = s.length()-1; i < j; i++, j--)
            if(s.charAt(i) != s.charAt(j))
                return false;
        return true;
    }
}
