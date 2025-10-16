class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] map = new int[value];
        for(int x: nums){
            int rem = ((x % value) + value) % value;
            map[rem]++;
        }

        int mex = 0;
        while(map[mex % value] > 0){
            map[mex % value]--;
            mex++;
        }
        return mex;
    }
}
