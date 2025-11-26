class Solution {
    private int mod = (int)1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        int[][][] memo = new int[n][m][k];
        for (int[][] arr : memo)
            for (int[] row : arr)
                java.util.Arrays.fill(row, -1);

        return helper(grid, 0, 0, k, 0, memo);
    }

    private int helper(int[][] grid, int r, int c, int k, int sum, int[][][] memo) {
        if (r >= grid.length || c >= grid[0].length) return 0;

        sum = (sum + grid[r][c]) % k;

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return (sum % k == 0 ? 1 : 0);
        }

        if (memo[r][c][sum] != -1) return memo[r][c][sum];

        int ans1 = helper(grid, r + 1, c, k, sum, memo);
        int ans2 = helper(grid, r, c + 1, k, sum, memo);

        return memo[r][c][sum] = (ans1 % mod + ans2 % mod) % mod;
    }
}
