class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxTriplet = 0, maxElement = 0, maxDiff = 0;
        for (int num : nums) {
            maxTriplet = Math.max(maxTriplet, maxDiff * num);
            maxDiff = Math.max(maxDiff, maxElement - num);
            maxElement = Math.max(maxElement, num);
        }
        return maxTriplet;
    }
}
/*class Solution {
    public long maximumTripletValue(int[] nums) {
        long maxTriplet = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int k = nums.length - 1; k > i; k--) {
                int j = i + 1;
                while (j < k) {
                    maxTriplet = Math.max(maxTriplet, (long)(nums[i] - nums[j]) * nums[k]);
                    j++;
                }
            }
        }
        return Math.max(0, maxTriplet);
    }
}*/
