class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] prime = new boolean[right + 1];
        Arrays.fill(prime, true);

        if (right >= 0) prime[0] = false;
        if (right >= 1) prime[1] = false;

        for (int i = 2; i * i <= right; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= right; j += i)
                    prime[j] = false;
            }
        }

        int prev = -1, ans1 = -1, ans2 = -1, best = Integer.MAX_VALUE;

        for (int i = Math.max(2, left); i <= right; i++) {
            if (prime[i]) {
                if (prev != -1 && i - prev < best) {
                    best = i - prev;
                    ans1 = prev;
                    ans2 = i;
                }
                prev = i;
            }
        }

        return ans1 == -1 ? new int[]{-1, -1} : new int[]{ans1, ans2};
    }
}
