class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pcount = new int[primes.length];
        int[] ugly = new int[n];
        ugly[0] = 1;
        for(int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < primes.length; j++) {
                min = Math.min(min, ugly[pcount[j]] * primes[j]);
            }
            for(int j = 0; j < primes.length; j++) {
                if(min == ugly[pcount[j]] * primes[j])
                    pcount[j]++;
            }
            ugly[i] = min;
        }
        return ugly[n-1];
    }
}
