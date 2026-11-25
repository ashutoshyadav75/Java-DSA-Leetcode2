
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        int result = 0;

        for (int target = 1; target <= 26; target++) {
            int[] count = new int[26];

            int left = 0;
            int right = 0;
            int unique = 0;
            int countAtLeastK = 0;

            while (right < n) {
                if (unique <= target) {
                    int index = s.charAt(right) - 'a';

                    if (count[index] == 0) {
                        unique++;
                    }

                    count[index]++;

                    if (count[index] == k) {
                        countAtLeastK++;
                    }

                    right++;
                } else {
                    int index = s.charAt(left) - 'a';

                    if (count[index] == k) {
                        countAtLeastK--;
                    }

                    count[index]--;

                    if (count[index] == 0) {
                        unique--;
                    }

                    left++;
                }

                if (unique == target && unique == countAtLeastK) {
                    result = Math.max(result, right - left);
                }
            }
        }

        return result;
    }
}