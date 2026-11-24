
class NumArray {
    private int[] nums;
    private int[] bit;
    private int n;

    public NumArray(int[] nums) {
        this.n = nums.length;
        this.nums = nums.clone();
        this.bit = new int[n + 1];

        for (int i = 0; i < n; i++) {
            updateBIT(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        int diff = val - nums[index];
        nums[index] = val;
        updateBIT(index + 1, diff);
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

    private void updateBIT(int index, int value) {
        while (index <= n) {
            bit[index] += value;
            index += index & -index;
        }
    }

    private int query(int index) {
        int sum = 0;

        while (index > 0) {
            sum += bit[index];
            index -= index & -index;
        }

        return sum;
    }
}
