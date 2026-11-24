
class Solution {
    private int[][][] memo;

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();

        if (n != s2.length()) {
            return false;
        }

        memo = new int[n][n][n + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return dfs(s1, s2, 0, 0, n);
    }

    private boolean dfs(String s1, String s2,
                        int i, int j, int len) {

        if (memo[i][j][len] != -1) {
            return memo[i][j][len] == 1;
        }

        if (s1.regionMatches(i, s2, j, len)) {
            memo[i][j][len] = 1;
            return true;
        }

        int[] count = new int[26];

        for (int k = 0; k < len; k++) {
            count[s1.charAt(i + k) - 'a']++;
            count[s2.charAt(j + k) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) {
                memo[i][j][len] = 0;
                return false;
            }
        }

        for (int k = 1; k < len; k++) {

            if (dfs(s1, s2, i, j, k) &&
                dfs(s1, s2, i + k, j + k, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }

            if (dfs(s1, s2, i, j + len - k, k) &&
                dfs(s1, s2, i + k, j, len - k)) {
                memo[i][j][len] = 1;
                return true;
            }
        }

        memo[i][j][len] = 0;
        return false;
    }
}
