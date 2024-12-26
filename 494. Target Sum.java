class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (Math.abs(target) > sum || (target + sum) % 2 != 0) return 0;

        int subsetSum = (target + sum) / 2;
        int[] dp = new int[subsetSum + 1];
        dp[0] = 1; 
        
        for (int num : nums) {
            for (int i = subsetSum; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }

        return dp[subsetSum];
    }
}
494. Target Sum
