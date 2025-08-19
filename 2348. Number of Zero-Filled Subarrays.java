class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long zero = 0;
        long res = 0;

        for (int i: nums){
            if(i == 0){
                zero ++;
                res = zero + res;
            }
            else zero = 0;
        }

        return res;
    }
}
