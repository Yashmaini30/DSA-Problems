class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);                 

        Map<Integer, Integer> lastRain = new HashMap<>(); 
        TreeSet<Integer> dryDays = new TreeSet<>();     

        for (int i = 0; i < n; ++i) {
            if (rains[i] == 0) {
                dryDays.add(i);              
            } else {
                int lake = rains[i];
                if (lastRain.containsKey(lake)) {
                    int prevDay = lastRain.get(lake);
                    Integer dryDay = dryDays.higher(prevDay);
                    if (dryDay == null) {
                        return new int[0];
                    }
                    ans[dryDay] = lake;     
                    dryDays.remove(dryDay);
                }
                ans[i] = -1;                 
                lastRain.put(lake, i); 
            }
        }
        return ans;
    }
}
