class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> hset = new HashSet<>(wordList);
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        
        int count = 0;
        while(!queue.isEmpty()) {
            
            int len = queue.size();
            count ++;
            for(int k = 0; k < len ; k++) {
                String temp = queue.poll();
                if(endWord.equals(temp))
                     return count;
                char[] arr = temp.toCharArray();
                for(int i = 0; i < arr.length; i++) {
                char cur = arr[i];
                for(char j = 'a'; j <= 'z'; j++) {
                    if(cur != j) {
                        arr[i] = j;
                        String tempstr = String.valueOf(arr);
                        if(hset.contains(tempstr) && visited.add(tempstr))
                            queue.offer(tempstr);
                    }
                }
                arr[i] = cur;
            } 
            }
           
        }
        return 0;
    }
}
