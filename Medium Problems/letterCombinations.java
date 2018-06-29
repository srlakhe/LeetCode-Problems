class Solution {
    public List<String> letterCombinations(String digits) {
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        List<String> result = new ArrayList<>();
        if(digits.length() == 0)
            return result;
        result.add("");
        for(int i = 0; i < digits.length(); i++) {
            int c = digits.charAt(i) - '2';
            String str = map[c];
            int len = result.size();
            for(int j = 0; j < len; j++) {
                String temp = result.get(j);
                for(char ch: str.toCharArray()) {
                    String temp2 = temp + ch;
                    result.add(temp2);
                }     
            }
            for(int j = 0; j < len; j++)
                result.remove(0);
        }
        
        return result;
    }
}
