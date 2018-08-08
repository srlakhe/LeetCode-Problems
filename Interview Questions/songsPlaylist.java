class Solution {
static long playlist(List<Integer> songs) {
        int  n = songs.size();
        long count = 0; 
        HashMap<Integer, Integer> map = new HashMap();
        
        int i = 0;
        while(i < n) {
            int val = songs.get(i) % 60;
            if(val == 0) {
                if(map.containsKey(val))
                    count += map.get(val);
            }
            if(map.containsKey(60-val))
                count += map.get(60-val);
            map.put(val, map.getOrDefault(val, 0)+1);
            i++;
        }
        return count;
    }
}
