class Solution {
    HashMap<String, List<String>>hmap = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        if(s.length() == 0)
            return result;
        if(hmap.containsKey(s))
            return hmap.get(s);
        HashSet<String> dict = new HashSet<>();
        for(String word: wordDict)
            dict.add(word);
        for(int i = 0; i < s.length(); i++) {
            List<String> templist = new ArrayList<>();
            String temp = s.substring(0, i+1);
            if(dict.contains(temp)) {
                templist = wordBreak(s.substring(i+1, s.length()), wordDict);
                hmap.put(s.substring(i+1, s.length()), templist);
                for(String word: templist) {
                    result.add(temp + " " + word);
                }
                if(templist.size() == 0 && i == s.length()-1) {
                    result.add(temp);
                }
            }
        }
        return result;
    }
}
