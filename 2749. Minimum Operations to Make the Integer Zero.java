class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (int m = 1; m <= 60; m++) {
            long S = (long) num1 - (long) m * num2;  
            if (S < 0) continue;

            int popcount = Long.bitCount(S);
            if (popcount <= m && m <= S) {
                return m;
            }
        }
        return -1;
    }
}
