
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0, j = 0;

        while (i < v1.length || j < v2.length) {
            long num1 = i < v1.length ? Long.parseLong(v1[i]) : 0;
            long num2 = j < v2.length ? Long.parseLong(v2[j]) : 0;

            if (num1 < num2) return -1;
            if (num1 > num2) return 1;

            i++;
            j++;
        }

        return 0;
    }
}
