class Solution {
    class TrieNode {
        TrieNode[] child;
        String w;
        TrieNode() {
            child = new TrieNode[26];
        }
    }
    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        HashSet<String> hset = new HashSet();
        for(String word: words) {
            insertWord(root, word);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(root.child[board[i][j]-'a'] != null)
                    dfs(board, i, j, root, result);
            }
        }
        return result;
    }
    
    void dfs(char[][] board, int i, int j, TrieNode root, List<String> result) {
        
        char ch = board[i][j];
        if(ch == '#' || root.child[ch-'a']==null)
            return;
        root = root.child[ch-'a'];
        board[i][j] = '#';
        if(root.w != null) {
             result.add(root.w);
             root.w = null;
        }
        if(i+1 < board.length)
            dfs(board, i+1, j, root, result);
        if(i > 0)
            dfs(board, i-1, j, root, result);
        if(j+1 < board[0].length)
            dfs(board, i, j+1, root, result);
        if(j > 0)
         dfs(board, i, j-1, root, result);
        board[i][j]=ch;
    }
    void insertWord(TrieNode root, String word) {
        int len = word.length();
        for(int i = 0; i < len; i++) {
            int c = word.charAt(i)-'a';
            if(root.child[c] == null)
                root.child[c] = new TrieNode();
            root = root.child[c];
        }
        root.w = word;
    }
  
}
