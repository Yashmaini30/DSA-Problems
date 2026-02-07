class Solution {
    public int minimumDeletions(String s) {
        int bCount = 0;
        int ans = 0;

        for (char c : s.toCharArray()) {
            if (c == 'b') {
                bCount++;
            } else { // 'a'
                ans = Math.min(ans + 1, bCount);
            }
        }
        return ans;
        /*
        int n = s.length();
        int aCount[] = new int[n];
        int bCount[] = new int[n];

        bCount[0] = 0;
        // bCount - left to right
        for(int i=1;i<n;i++){
            char prevCh = s.charAt(i-1);
            bCount[i] = bCount[i-1];
            if(prevCh == 'b'){
                bCount[i] += 1;
            }
        }

        aCount[n-1] = 0;
        // aCount - right to left
        for(int i=n-2;i>=0;i--){
            char nextCh = s.charAt(i+1);
            aCount[i] = aCount[i+1];
            if(nextCh == 'a'){
                aCount[i] += 1;
            }
        }

        int minDel = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            minDel = Math.min(minDel, aCount[i]+bCount[i]);
        }
        return minDel;
        */

        /*
        int aRemaining = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') aRemaining++;
        }

        int bSeen = 0;
        int minDel = aRemaining; // split before the first character

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == 'a') {
                aRemaining--;
            } else { // 'b'
                bSeen++;
            }

            minDel = Math.min(minDel, bSeen + aRemaining);
        }

        return minDel;
        */
    }
}
