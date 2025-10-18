class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int count = 1;
        int n = nums.length;

        Arrays.sort(nums);
        int prev = nums[0] - k;

        for (int i = 1; i < n; i++) {
            int currMin = Math.max(prev + 1, nums[i] - k);
            if (currMin <= nums[i] + k) {
                count++;
                prev = currMin;
            } else {
                prev = nums[i] + k;
            }
        }
        return count;

    }
}
