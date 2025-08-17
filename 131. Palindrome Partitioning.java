import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>>[][] memo = new ArrayList[n][n];
        return solve(s, 0, n - 1, memo);
    }

    private List<List<String>> solve(String s, int i, int j,
                                     List<List<String>>[][] memo) {
        if (i > j) return new ArrayList<>();

        if (memo[i][j] != null) return memo[i][j];

        List<List<String>> ans = new ArrayList<>();
        if (isPalindrome(s, i, j)) {
            List<String> single = new ArrayList<>();
            single.add(s.substring(i, j + 1));
            ans.add(single);
        }

        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                String leftPart = s.substring(i, k + 1);
                List<List<String>> rightPartitions = solve(s, k + 1, j, memo);

                for (List<String> right : rightPartitions) {
                    List<String> newPartition = new ArrayList<>();
                    newPartition.add(leftPart);
                    newPartition.addAll(right);
                    ans.add(newPartition);
                }
            }
        }

        memo[i][j] = ans;
        return ans;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}
