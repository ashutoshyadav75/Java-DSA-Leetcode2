
class Solution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int[] pathLength = new int[lines.length + 1];

        int maxLength = 0;

        for (String line : lines) {
            int depth = 0;

            while (depth < line.length() && line.charAt(depth) == '\t') {
                depth++;
            }

            String name = line.substring(depth);

            if (name.contains(".")) {
                maxLength = Math.max(
                    maxLength,
                    pathLength[depth] + name.length()
                );
            } else {
                pathLength[depth + 1] =
                    pathLength[depth] + name.length() + 1;
            }
        }

        return maxLength;
    }
}
