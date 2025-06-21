class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        int MOD = 1000000007;
        long count = 0;
        
        Map<Integer, Integer> rFreq = new HashMap<>();
        for (int k = 2; k < n; k++) {
            rFreq.put(nums[k], rFreq.getOrDefault(nums[k], 0) + 1);
        }
        
        Map<Integer, Integer> lFreq = new HashMap<>();
        lFreq.put(nums[0], 1);
        
        for (int j = 1; j < n - 1; j++) {
            int tar = nums[j] * 2;
            
            int lCount = lFreq.getOrDefault(tar, 0);
            int rCount = rFreq.getOrDefault(tar, 0);
            
            count = (count + (long)lCount * rCount) % MOD;
            
            if (j + 1 < n - 1) {
                lFreq.put(nums[j], lFreq.getOrDefault(nums[j], 0) + 1);

                int nextK = nums[j + 1];
                rFreq.put(nextK, rFreq.get(nextK) - 1);
                if (rFreq.get(nextK) == 0) {
                    rFreq.remove(nextK);
                }
            }
        }
        
        return (int)count;
    }
}
