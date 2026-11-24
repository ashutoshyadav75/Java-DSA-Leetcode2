
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean transpose = rows > cols;
        int m = Math.min(rows, cols);
        int n = Math.max(rows, cols);

        int ans = Integer.MIN_VALUE;

        for (int top = 0; top < m; top++) {
            int[] sums = new int[n];

            for (int bottom = top; bottom < m; bottom++) {
                for (int j = 0; j < n; j++) {
                    sums[j] += transpose
                        ? matrix[j][bottom]
                        : matrix[bottom][j];
                }

                TreeSet<Integer> set = new TreeSet<>();
                set.add(0);

                int prefix = 0;

                for (int sum : sums) {
                    prefix += sum;

                    Integer ceiling = set.ceiling(prefix - k);

                    if (ceiling != null) {
                        ans = Math.max(ans, prefix - ceiling);
                    }

                    if (ans == k) {
                        return k;
                    }

                    set.add(prefix);
                }
            }
        }

        return ans;
    }
}
