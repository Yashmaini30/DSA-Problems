class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        ArrayList<Integer> res = new ArrayList<>();

        int n = nums.length;
        int expected = 1;
        int i = 0;

        while (expected <= n) {
            if (i >= n || nums[i] > expected) {
                res.add(expected);
                expected++;
            }
            else if (nums[i] == expected) {
                i++;
                expected++;
            } 
            else {
                i++;
            }
        }

        return res;
    }
}
