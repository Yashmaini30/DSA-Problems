class Solution {
    public int[] sumZero(int n) {
        int[] res = new int[n];
        int ind = 0;
        
        // Add pairs (+i, -i)
        for (int i = 1; i <= n / 2; i++) {
            res[ind++] = i;
            res[ind++] = -i;
        }
        if (n % 2 == 1) {
            res[ind] = 0;
        }
        
        return res;
    }
}
