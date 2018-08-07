class Solution {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        Stack<Character> stack = new Stack<>();
        char[] sa = s.toCharArray();
        for(char ch: sa) {
            count[ch-'a']++;
        }
        boolean[] visited = new boolean[26];
        for(char ch: sa) {
            count[ch-'a']--;
            if(visited[ch-'a'])
                continue;
            while(!stack.isEmpty() && ch < stack.peek() && count[stack.peek()-'a'] > 0) {
                visited[stack.pop()-'a']=false;
            }
            visited[ch-'a']=true;
            stack.push(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.reverse().toString();
    }
}
