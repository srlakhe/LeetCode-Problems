class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        HashMap<Integer, Integer> hmap = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            if(hmap.containsKey(target - nums[i])) {
                res[1] = i;
                res[0] = hmap.get(target - nums[i]);
                return res;
            }
            hmap.put(nums[i], i);
        }
        return res;
    }
}
