class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtrack(res, sb, 0, target, 0, num.toCharArray(), 0);
        return res;
    }
    
    void backtrack(List<String> res, StringBuilder sb, long sum, int target, int start, char[] num, long cur) {
        if(start == num.length) {
            if(sum == (long)target) {
                res.add(sb.toString());
            }
            return;
        }
        
        long val = 0;
        for(int i = start; i < num.length; i++) {
             if(i > start && num[start] == '0')
                break;
             val = Long.parseLong(new String(num, start, i-start+1));

            if(sb.length() == 0) {
                backtrack(res, sb.append(val), val, target, i+1, num, val);
                sb.setLength(0);
                continue;
            }
            int len = sb.length();
            backtrack(res, sb.append("+").append(val), sum + val, target, i+1, num, val);
            sb.setLength(len);
            backtrack(res, sb.append("-").append(val), sum - val, target, i+1, num, -val);
            sb.setLength(len);
            backtrack(res, sb.append("*").append(val), (sum - cur) + cur * val, target, i+1, num, cur*val);
            sb.setLength(len);           
        }
       
    }
}
