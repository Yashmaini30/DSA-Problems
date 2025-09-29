class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];

        return solve(values, 0, values.length - 1, dp);
    }

    private int solve(int[] values, int i, int j, int[][] dp) {
        if (j - i < 2) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i + 1; k < j; k++) {
            int cost = solve(values, i, k, dp) 
                     + values[i] * values[k] * values[j] 
                     + solve(values, k, j, dp);
            min = Math.min(min, cost);
        }
        dp[i][j] = min; 
        return dp[i][j];
    }
}
