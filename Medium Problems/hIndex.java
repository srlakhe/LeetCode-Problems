class Solution {
    public int hIndex(int[] citations) {
        if(citations.length == 0)
            return 0;
        Arrays.sort(citations);
        int i = citations.length-1;
        int j = 0;
        while(j < citations.length && citations[citations.length-1-j] > j)
            j++;
        return j;
    }
}
