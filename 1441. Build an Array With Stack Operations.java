class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ops = new ArrayList<>();
        int t = 0;

        for(int x=1;x <= target[target.length - 1];x++){
            ops.add("Push");
            if( x == target[t]){
                t++;
                if(t == target.length) break;
            }else{
                ops.add("Pop");
            }
        }
        return ops;
    }
}
