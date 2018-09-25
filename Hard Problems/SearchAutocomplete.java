class AutocompleteSystem {

    class TrieNode {
        HashMap<Character, TrieNode> child;
        HashMap<String, Integer> counts;
        String prefix;
        TrieNode() {
            child = new HashMap<>();
            counts = new HashMap<>();
        }
    }
    
    class Pair {
        String s;
        int c;
        Pair(String s, int c) {
            this.s = s;
            this.c = c;
        }
    }
    
    TrieNode root;
    String prefix;
    public void addSentence(String sentence, int times) {
        TrieNode itr = root;
        for(char c: sentence.toCharArray()) {
            TrieNode next = itr.child.get(c);
            if(next == null) {
                next = new TrieNode();
                itr.child.put(c, next);
            }
            itr = next;
            itr.counts.put(sentence, itr.counts.getOrDefault(sentence, 0)+times);
        }
    }
    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new TrieNode();
        prefix = "";
        for(int i = 0; i < sentences.length; i++)
            addSentence(sentences[i], times[i]);
    }
    
    public List<String> input(char c) {
        if(c == '#') {
            addSentence(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        }
        prefix = prefix + c;
        TrieNode itr = root;
        for(char cc: prefix.toCharArray()) {
            TrieNode next = itr.child.get(cc);
            if(next == null)
                return new ArrayList<>();
            itr = next;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.c == b.c ? a.s.compareTo(b.s) : b.c - a.c));
        for(String s: itr.counts.keySet()) {
            pq.add(new Pair(s, itr.counts.get(s)));
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < 3 && !pq.isEmpty(); i++) {
            result.add(pq.poll().s);
        }
        return result;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
