class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int lo = 0, hi = nums[nums.length - 1] - nums[0];
        
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canForm(nums, p, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        
        return lo;
    }
    private boolean canForm(int[] nums, int p, int maxDiff) {
        int count = 0;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] - nums[i - 1] <= maxDiff) {
                count++;
                i += 2; 
                if (count >= p) return true;
            } else {
                i++;
            }
        }
        return count >= p;
    }

}
