class Solution {
    public int[] constructDistancedSequence(int n) {
        int [] ans = new int[2*n-1];
        boolean [] used = new boolean[n+1];
        backtrack(ans, used, n, 0);
        return ans;
    }
    private boolean backtrack(int[] ans, boolean[] used, int n, int index){
        while(index < ans.length && ans[index] != 0){
            index++;
        }
        if(index == ans.length){
            return true;
        }
        for(int i = n; i >= 1; i--){
            if(used[i]) continue;

            if(i == 1){
                ans[index] = 1;
                used[1] = true;
                if(backtrack(ans, used, n, index + 1)) return true;
                ans[index] = 0;
                used[1] = false;
            }
            else{
                if(index + i < ans.length && ans[index + i] == 0){
                    ans[index] = i;
                    ans[index + i] = i;
                    used[i] = true;
                    if(backtrack(ans, used, n, index + 1)) return true;
                    ans[index] = 0;
                    ans[index + i] = 0;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}
