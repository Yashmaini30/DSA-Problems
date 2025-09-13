class Solution {
    public int maxFreqSum(String s) {
        int[] freq = new int [26];
        int maxVow = 0, maxCon = 0;

        for(char c : s.toCharArray()){
            int i = c - 'a';
            freq[i]++;

            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                maxVow = Math.max(maxVow, freq[i]);
            }
            else{
                maxCon = Math.max(maxCon, freq[i]);
            }
        }
        return maxVow + maxCon;
    }
}
