class Solution {
    public int minimumCost(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            if (x < first) {
                second = first;
                first = x;
            } else if (x < second) {
                second = x;
            }
        }
        return nums[0] + first + second;
        // int first = nums[0];

        // Arrays.sort(nums,1,nums.length);
        // return first + nums[1] + nums[2];
    }
}
