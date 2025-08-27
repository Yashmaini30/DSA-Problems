class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i]; 
            jobs[i][1] = endTime[i];  
            jobs[i][2] = profit[i];   
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            ends[i] = jobs[i][1];
        }

        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            int s = jobs[i - 1][0];
            int p = jobs[i - 1][2];
            
            int idx = upperBound(ends, 0, i - 1, s) - 1; 

            dp[i] = Math.max(dp[i - 1], dp[idx + 1] + p);
        }
        
        return dp[n];
    }
    private int upperBound(int[] arr, int from, int to, int target) {
        int l = from, r = to;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (arr[m] <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}
