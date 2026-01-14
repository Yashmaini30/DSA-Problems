class Solution {
    public int minOperations(int[] nums) {
        int addOneOperations = 0; 
        int highestSetBit = 0; 
        for (int bit = 0; bit <= 30; ++bit) {
            for (int num : nums) {
                if ((num & (1 << bit)) != 0) {
                    addOneOperations++;
                    highestSetBit = bit;
                }
            }
        }
        return addOneOperations + highestSetBit;
    }
}
