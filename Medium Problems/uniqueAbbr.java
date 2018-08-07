public class ValidAbbreviation {
    
    private HashMap<String, HashSet<String>> hmap;
    public ValidAbbreviation(String[] dictionary) {
        hmap = new HashMap<>();
        for(int i = 0; i < dictionary.length; i++) {
            String s = dictionary[i];
            if(s.length() > 2) {
                s = s.charAt(0) + s.length()-2 + s.charAt(s.length()-1);
            }
            if(!hmap.containsKey(s)) {
                hmap.put(s, new HashSet<>());
            }
            hmap.get(s).add(dictionary[i];)
        }
    }
    public boolean isUnique(String word) {
        String s = word;
        if(word.length()>2) {
            s = word.charAt(0) + word.length()-2 + word.charAt(word.length()-1);
        }
        if(!hmap.containsKey(s))
            return true;
        return (hmap.get(s).size() <= 1) && hmap.get(s).contains(word); 
    }
}
