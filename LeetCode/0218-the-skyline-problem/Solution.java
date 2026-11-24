
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();

        for (int[] building : buildings) {
            events.add(new int[]{building[0], -building[2]});
            events.add(new int[]{building[1], building[2]});
        }

        events.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(0, 1);

        List<List<Integer>> result = new ArrayList<>();
        int prevMax = 0;
        int i = 0;

        while (i < events.size()) {
            int x = events.get(i)[0];

            while (i < events.size() && events.get(i)[0] == x) {
                int h = events.get(i)[1];

                if (h < 0) {
                    map.put(-h, map.getOrDefault(-h, 0) + 1);
                } else {
                    int count = map.get(h);

                    if (count == 1) {
                        map.remove(h);
                    } else {
                        map.put(h, count - 1);
                    }
                }

                i++;
            }

            int currentMax = map.lastKey();

            if (currentMax != prevMax) {
                result.add(Arrays.asList(x, currentMax));
                prevMax = currentMax;
            }
        }

        return result;
    }
}
