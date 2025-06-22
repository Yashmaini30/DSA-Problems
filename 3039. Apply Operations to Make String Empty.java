class Solution {
    public String lastNonEmptyString(String s) {
        
        Map<Character,Integer> map = new HashMap<>();
        int maxFreq = 0;

        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
            maxFreq = Math.max(maxFreq,map.get(c));
        }

        StringBuilder ans = new StringBuilder();

        for(int i = s.length() - 1; i >= 0; i--){
            char c = s.charAt(i);
            if(map.get(c) == maxFreq){
                ans.append(c);
                map.put(c,map.get(c) - 1);
            }
        }

        return ans.reverse().toString();
    }
}
