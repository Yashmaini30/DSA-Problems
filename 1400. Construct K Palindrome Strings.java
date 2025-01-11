class Solution {
    public boolean canConstruct(String s, int k) {
        int n = s.length();
        if(n<k) return false;
        if(n==k) return true;

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int oddCount=0;
        for(int freq:map.values()){
            if(freq % 2 != 0) oddCount++;
        }
        return oddCount <=k;
    }
}
