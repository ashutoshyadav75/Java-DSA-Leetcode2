

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] degree = new int[m][n];

        int[][] directions = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

        Queue<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] d : directions) {
                    int r = i + d[0];
                    int c = j + d[1];

                    if (r >= 0 && r < m && c >= 0 && c < n
                            && matrix[r][c] > matrix[i][j]) {
                        degree[i][j]++;
                    }
                }

                if (degree[i][j] == 0) {
                    queue.offer(i * n + j);
                }
            }
        }

        int result = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            result++;

            for (int i = 0; i < size; i++) {
                int cell = queue.poll();

                int r = cell / n;
                int c = cell % n;

                for (int[] d : directions) {
                    int nr = r + d[0];
                    int nc = c + d[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n
                            && matrix[nr][nc] < matrix[r][c]) {

                        degree[nr][nc]--;

                        if (degree[nr][nc] == 0) {
                            queue.offer(nr * n + nc);
                        }
                    }
                }
            }
        }

        return result;
    }
}
