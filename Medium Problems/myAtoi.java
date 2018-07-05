class Solution {
    public int myAtoi(String str) {
        if(str.isEmpty())
            return 0;
        
        int sign = 1, res = 0, i = 0;
        while(str.charAt(i) == ' ')
            i++;
        
        if(str.charAt(i) == '+' || str.charAt(i) == '-')
            sign = str.charAt(i++) == '-'? -1 : 1;
        
        while(i < str.length() && Character.isDigit(str.charAt(i))) {
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && str.charAt(i)-'0' > 7)) 
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + (str.charAt(i++) - '0');
        }
        return sign * res;
    }
}
