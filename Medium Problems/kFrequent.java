class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            hmap.put(nums[i], hmap.getOrDefault(nums[i], 0)+1);
        }
        
        List<Integer>[] sortedMap = new ArrayList[nums.length+1];
        for(int num : hmap.keySet()) {
            int freq = hmap.get(num);
            if(sortedMap[freq] == null)
                sortedMap[freq] = new ArrayList<>();
            sortedMap[freq].add(num);
        }
        
        for(int i = sortedMap.length-1; i > 0 && result.size() < k; i--) {
            if(sortedMap[i] != null) {
                result.addAll(sortedMap[i]);                
            }
        }
        return result;   
    }
}
