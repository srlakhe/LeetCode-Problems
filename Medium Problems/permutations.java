class Solution {
    public List<List<Integer>> permute(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<Integer>(), 0, nums);
        return result;
    }
    
    void backtrack(ArrayList<List<Integer>> result, ArrayList<Integer> temp, int n, int[] nums) {
        if(n == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length ; i++) {
            if(temp.contains(nums[i]))
               continue;
            temp.add(nums[i]);
            backtrack(result, temp, n+1, nums);
            temp.remove(temp.size()-1);
        }
    }
}
