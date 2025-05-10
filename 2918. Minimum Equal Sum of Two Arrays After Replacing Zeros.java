class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        int zero1 = 0, zero2 = 0;
        for(int x: nums1) if (x == 0) zero1++;
        for(int x: nums2) if (x == 0) zero2++;

        long sum1 = zero1, sum2 = zero2;
        for(int x: nums1) sum1 += x;
        for(int x: nums2) sum2 += x;

        if((sum1 < sum2 && zero1 == 0) || (sum2 < sum1 && zero2 == 0)) return -1;
        return Math.max(sum1,sum2);
    }
}
