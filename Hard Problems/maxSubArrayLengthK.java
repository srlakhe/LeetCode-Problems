public class Solution {
    private int maxSubArrayLengthK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += num[i];
            if(sum == k)
                max = Math.max(max, i+1);
            int diff = sum - k;
            if(map.containsKey(diff))
                max = Math.max(max, i - map.get(diff));
            if(!map.containsKey(sum))
                map.put(sum, i)
        }
        return max;
    }
}
