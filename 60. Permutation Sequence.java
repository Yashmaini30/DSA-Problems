class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums = new ArrayList<>();
        for (int i = 1; i <= n; i++) nums.add(i);

        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) fact[i] = fact[i-1] * i;

        k--; // convert to 0-based
        StringBuilder ans = new StringBuilder();

        for (int i = n; i >= 1; i--) {
            int block = fact[i-1];
            int index = k / block;
            ans.append(nums.get(index));
            nums.remove(index);
            k %= block;
        }

        return ans.toString();
    }
    // public String getPermutation(int n, int k) {
    //     List<String> all = new ArrayList<>();
    //     boolean[] used = new boolean[n+1];
    //     backtrack(n, used, new StringBuilder(), all);
    //     return all.get(k-1); 
    // }

    // private void backtrack(int n, boolean[] used, StringBuilder curr, List<String> all) {
    //     if (curr.length() == n) {
    //         all.add(curr.toString());
    //         return;
    //     }

    //     for (int i = 1; i <= n; i++) {
    //         if (!used[i]) {
    //             used[i] = true;
    //             curr.append(i);
    //             backtrack(n, used, curr, all);
    //             curr.deleteCharAt(curr.length() - 1);
    //             used[i] = false;
    //         }
    //     }
    // }
}
