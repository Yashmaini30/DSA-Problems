class Solution {
    public int maximumCount(int[] nums) {
        int negCount = binSearch(nums, 0);
        int posCount = nums.length - binSearch(nums, 1);
        return Math.max(negCount, posCount);
    }

    private int binSearch(int[] nums, int target){
        int low=0;
        int high = nums.length - 1;
        int res = nums.length;

        while(low<=high){
            int mid=(high+low)/2;
            if(nums[mid] < target){
                low = mid+1;
            }else{
                res = mid;
                high = mid-1;
            }
        }
        return res;
    }
}
