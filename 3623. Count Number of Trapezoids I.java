class Solution {
    public int countTrapezoids(int[][] points) {
        int mod = 1000000007;
        Map<Integer, Integer> map = new HashMap<>();
        for(int[] p: points){
            int y = p[1];
            if(!map.containsKey(y)){
                map.put(y, 0);
            }
            map.put(y, map.get(y) + 1);
        }

        int ans = 0;
        long prefix = 0;
        for(int cnt: map.values()){
            long currSegment = (long) (cnt) * (cnt - 1) / 2;
            currSegment %= mod;
            ans = (ans % mod + (int) ((currSegment * prefix) % mod)) % mod;
            prefix = (prefix % mod + currSegment) % mod;
        }

        return ans;
    }
}
