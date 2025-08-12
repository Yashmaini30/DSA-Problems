class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int[][] dp = computeLCSLengthTable(str1, str2);
        String lcs = reconstructLCS(str1, str2, dp);
        return mergeStringsUsingLCS(str1, str2, lcs);
    }

    private int[][] computeLCSLengthTable(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp;
    }

    private String reconstructLCS(String s1, String s2, int[][] dp) {
        StringBuilder lcs = new StringBuilder();
        int i = s1.length();
        int j = s2.length();

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                lcs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] >= dp[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        return lcs.reverse().toString();
    }

    private String mergeStringsUsingLCS(String s1, String s2, String lcs) {
        StringBuilder scs = new StringBuilder();
        int i = 0, j = 0;

        for (char ch : lcs.toCharArray()) {
            while (i < s1.length() && s1.charAt(i) != ch) {
                scs.append(s1.charAt(i++));
            }

            while (j < s2.length() && s2.charAt(j) != ch) {
                scs.append(s2.charAt(j++));
            }
            scs.append(ch);
            i++;
            j++;
        }
        if (i < s1.length()) scs.append(s1.substring(i));
        if (j < s2.length()) scs.append(s2.substring(j));

        return scs.toString();
    }
}
