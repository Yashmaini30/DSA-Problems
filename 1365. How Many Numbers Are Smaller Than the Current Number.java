class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] freq = new int[101];

        for(int x:nums){
            freq[x]++;
        }

        for (int i = 1; i < 101; i++) {
            freq[i] += freq[i - 1];
        }
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            res[i] = val == 0 ? 0 : freq[val - 1];
        }

        return res;
    }
}
