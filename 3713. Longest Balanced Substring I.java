
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int[] freq = new int[26];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(freq, 0);
            int max = 0, count = 0;
            for (int j = i; j < n; ++j) {
                int c = s.charAt(j) - 'a';
                if (freq[c]++ == 0) {
                    count++;
                }
                max = Math.max(max, freq[c]);
                if (max * count == j - i + 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}
