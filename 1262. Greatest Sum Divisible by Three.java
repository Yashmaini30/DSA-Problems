class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];

        for(int num:nums){
            int[] curr = dp.clone();

            for(int sum: curr){
                int newSum = sum + num;
                int rem = newSum % 3;

                dp[rem] = Math.max(dp[rem],newSum);
            }
        }
        return dp[0];
    }
}
