class Solution {
    public int calculate(String s) {
        int num = 0;
        int res = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for(char ch: s.toCharArray()) {
            if(Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } else if(ch == '+' || ch == '-') {
                res += sign*num;
                num = 0;
                sign = ch == '+' ? 1 : -1;
            } else if(ch == '(') {
                stack.push(res);
                stack.push(sign);
                sign = 1;
                res = 0;
            } else if(ch == ')') {
                res += sign*num;
                res *= stack.pop();
                res += stack.pop();
                sign = 1;
                num = 0;
            }
        }
        if(num != 0)
            res += sign*num;
        return res;
    }
}
