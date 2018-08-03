class Solution {
    public int romanToInt(String s) {
        char[] arr = s.toCharArray();
        int res = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(arr[i] == 'V')
                res += 5;
            if(arr[i] == 'L')
                res += 50;
            if(arr[i] == 'D')
                res += 500;
            if(arr[i] == 'M')
                res += 1000;
            if(arr[i] == 'I')
                res += res >= 5 ? -1 : 1;
            if(arr[i] == 'X')
                res += res >= 50 ? -10 : 10;
            if(arr[i] == 'C')
                res += res >= 500 ? -100 : 100;
        }
        return res;
    }
}
