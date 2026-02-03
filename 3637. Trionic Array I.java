class Solution {

    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;

        int peak = -1, valley = n;

        for (int i = 0; i < n - 1; i++) {
            if (peak == -1 && nums[i] >= nums[i + 1]) {
                peak = i;
            }

            int j = n - 1 - i;
            if (j - 1 >= 0 && valley == n && nums[j] <= nums[j - 1]) {
                valley = j;
            }

            if (peak > 0 && valley < n - 1) {
                return peak < valley && isDecreasing(nums, peak, valley);
            }
        }

        return false;
    }

    boolean isDecreasing(int[] nums, int a, int b) {
        for (int i = a; i < b; i++) {
            if (nums[i] <= nums[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
