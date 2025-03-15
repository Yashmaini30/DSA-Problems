class Solution {
    public int minCapability(int[] nums, int k) {
        int minReward = 1, maxReward = Arrays.stream(nums).max().getAsInt();
        int n = nums.length;

        while (minReward < maxReward) {
            int midReward = (minReward + maxReward) / 2;
            int possibleThefts = 0;

            for (int i = 0; i < n; i++) {
                if (nums[i] <= midReward) {
                    possibleThefts++;
                    i++;
                }
            }

            if (possibleThefts >= k)
                maxReward = midReward;
            else
                minReward = midReward + 1;
        }

        return minReward;
    }
}
