class RandomizedSet {

    ArrayList<Integer> list;
    HashMap<Integer, Integer> hmap;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        hmap = new HashMap<>();
        random = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(hmap.containsKey(val))
            return false;
        list.add(val);
        hmap.put(val, list.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!hmap.containsKey(val))
            return false;
        int index = hmap.get(val);
       
        if(index < list.size()-1) {
             list.set(index, list.get(list.size()-1));
             hmap.put(list.get(list.size()-1), index);   
        }
        hmap.remove(val);
        list.remove(list.size()-1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
