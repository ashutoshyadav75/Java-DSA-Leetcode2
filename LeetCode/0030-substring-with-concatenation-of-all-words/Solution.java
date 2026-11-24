
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (words.length == 0 || s.length() == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalWords = words.length;

        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int count = 0;

            Map<String, Integer> seen = new HashMap<>();

            for (int j = i; j + wordLen <= s.length(); j += wordLen) {
                String word = s.substring(j, j + wordLen);

                if (!wordCount.containsKey(word)) {
                    seen.clear();
                    count = 0;
                    left = j + wordLen;
                    continue;
                }

                seen.put(word, seen.getOrDefault(word, 0) + 1);
                count++;

                while (seen.get(word) > wordCount.get(word)) {
                    String leftWord = s.substring(left, left + wordLen);

                    seen.put(leftWord, seen.get(leftWord) - 1);
                    count--;
                    left += wordLen;
                }

                if (count == totalWords) {
                    result.add(left);

                    String leftWord = s.substring(left, left + wordLen);
                    seen.put(leftWord, seen.get(leftWord) - 1);

                    count--;
                    left += wordLen;
                }
            }
        }

        return result;
    }
}
