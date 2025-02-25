class Solution {
    public int numOfSubarrays(int[] arr) {
        long oddCount = 0, evenCount = 1, prefixSum = 0, result = 0;
        int MOD = 1_000_000_007;

        for (int a : arr) {
            prefixSum += a;
            if (prefixSum % 2 == 0) {
                result = (result + oddCount) % MOD;
                evenCount++;
            } else {
                result = (result + evenCount) % MOD;
                oddCount++;
            }
        }

        return (int) result;
    }
}
