class Solution {
    public boolean isPalindrome(String s) {
        if(s.length() == 0 || s.length() == 1)
            return true;
        char[] str = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(!Character.isLetterOrDigit(str[i])) {
                i++;
                continue;
            }
            if(!Character.isLetterOrDigit(str[j])) {
                j--;
                continue;
            }
            if(Character.toLowerCase(str[i]) != Character.toLowerCase(str[j]))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
