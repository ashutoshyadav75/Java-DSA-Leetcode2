
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int m = primes.length;

        long[] dp = new long[n];
        int[] index = new int[m];
        long[] next = new long[m];

        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            next[i] = primes[i];
        }

        for (int i = 1; i < n; i++) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < m; j++) {
                min = Math.min(min, next[j]);
            }

            dp[i] = min;

            for (int j = 0; j < m; j++) {
                if (next[j] == min) {
                    index[j]++;
                    next[j] = dp[index[j]] * primes[j];
                }
            }
        }

        return (int) dp[n - 1];
    }
}
