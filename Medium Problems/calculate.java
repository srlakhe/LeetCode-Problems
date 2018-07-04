class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        
        char sign = '+';
        int num = 0;
       
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            while(Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            } 
            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if(sign == '+')
                    stack.push(num);
                else if(sign == '-')
                     stack.push(num * -1);
                else if(sign == '*')
                    stack.push(stack.pop() * num);
                else
                    stack.push(stack.pop() / num);
                num = 0;
                sign = ch;
            } 
        }
        
        int result = 0;
        while(!stack.isEmpty())
            result += stack.pop();
        return result;
    }
}
