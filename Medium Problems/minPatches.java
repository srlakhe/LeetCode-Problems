class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0, i = 0;
        long patch=1;
        while(patch <= n) {
            if(i < nums.length && patch>=nums[i]) {
                patch += nums[i++];
                continue;
            }
            patch += patch;
            count++;
        }
        return count;
    }
}
