class Solution {
    public int minimumOperations(int[] nums) {
        int n=nums.length;
        Set<Integer> map=new HashSet<>();
        for(int i=n-1;i>=0;i--){
            if(map.contains(nums[i])){
                return i/3 + 1;
            }
            map.add(nums[i]);
        }
        return 0;
    }
}
