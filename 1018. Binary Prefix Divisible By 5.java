class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int curr = 0;
        ArrayList<Boolean> res = new ArrayList<>();
        for(int bit: nums){
            curr = (curr*2 + bit) % 5;
            if(curr == 0) res.add(true);
            else res.add(false);
        }
        return res;
    }
}
