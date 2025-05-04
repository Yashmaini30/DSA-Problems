class Solution {
    public int numEquivDominoPairs(int[][] dominoes) {
        int [] map = new int[100];
        int count = 0;
        for(int [] d: dominoes){
            if (d[0] > d[1])  map[d[0] * 10 + d[1]]++;
            else map[d[1] * 10 + d[0]]++;
        }

        for(int n : map){
            count += (n-1) * n/2;
        }
        return count;

    }
}
