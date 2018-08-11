class WordDictionary {
    class TrieNode {
            TrieNode[] arr;
            boolean isEnd;
            public TrieNode() {
                arr = new TrieNode[26];
            }
    }

    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode p = root;
        for(char c: word.toCharArray()) {
            if(p.arr[c-'a'] == null)
                p.arr[c-'a'] = new TrieNode();
            p = p.arr[c-'a'];
        }
        p.isEnd = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return match(root, word, 0);
    }
    
    public boolean match(TrieNode root, String word, int start) {
        if(start == word.length() && root.isEnd)
            return true;
        if(start >= word.length())
            return false;
        char c = word.charAt(start);
        if(c == '.') {
            for(int i = 0; i < 26; i++) {
                if(root.arr[i] != null) {
                    if(match(root.arr[i], word, start+1))
                        return true;
                }
            }
            return false;
        } else {
            if(root.arr[c-'a'] != null) {
                return match(root.arr[c-'a'], word, start+1);
            } else
                return false;
        }
    }
    
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
