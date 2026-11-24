

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            for (int j = 0; j <= word.length(); j++) {
                String left = word.substring(0, j);
                String right = word.substring(j);

                if (isPalindrome(left)) {
                    String reverseRight = reverse(right);

                    if (map.containsKey(reverseRight) &&
                        map.get(reverseRight) != i) {
                        result.add(Arrays.asList(map.get(reverseRight), i));
                    }
                }

                if (j != word.length() && isPalindrome(right)) {
                    String reverseLeft = reverse(left);

                    if (map.containsKey(reverseLeft) &&
                        map.get(reverseLeft) != i) {
                        result.add(Arrays.asList(i, map.get(reverseLeft)));
                    }
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

