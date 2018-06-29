class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hmap = new HashMap<>();
        
        for(String str: strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if(!hmap.containsKey(key)) {
                hmap.put(key, new ArrayList<>());
            }
            
            List<String> temp = hmap.get(key);
            temp.add(str);
            hmap.put(key, temp);
        }
        
        return new ArrayList<>(hmap.values());
    }
}
