class Solution {
    public int longestConsecutive(int[] nums) {
        
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(hmap.containsKey(nums[i]))
                continue;
            int left = 0, right = 0;
            left = hmap.getOrDefault(nums[i]-1, 0);
            right = hmap.getOrDefault(nums[i]+1, 0);
            if(left != 0)
                hmap.put(nums[i] - left, left+right+1);
            if(right != 0)
                hmap.put(nums[i] + right, left+right+1);
            hmap.put(nums[i], left + right + 1);
        }
        
        int max = 0;
        for(Map.Entry<Integer, Integer> entry : hmap.entrySet())
            max = Math.max(max, entry.getValue());
        return max;
    }
}
