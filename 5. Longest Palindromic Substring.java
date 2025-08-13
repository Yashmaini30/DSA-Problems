public class Solution {
    private int[][] buildLCSS(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp;
    }

    private String reconstructLCSS(String s1, String s2, int[][] dp) {
        int maxLen = 0;
        int endIndex = 0; 

        int n = s1.length();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int origStart = i - dp[i][j];
                if (dp[i][j] > maxLen && origStart == n - j) {
                    maxLen = dp[i][j];
                    endIndex = i;
                }
            }
        }
        return s1.substring(endIndex - maxLen, endIndex);
    }

    public String longestPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        int[][] dp = buildLCSS(s, reversed);
        return reconstructLCSS(s, reversed, dp);
    }
}
