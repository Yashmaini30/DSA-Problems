class Solution {
    public int maxDistance(String s, int k) {
        int north = 0, south = 0, east = 0, west = 0;
        int maxDist = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'N') north++;
            else if (c == 'S') south++;
            else if (c == 'E') east++;
            else if (c == 'W') west++;

            int MD = Math.abs(north - south) + Math.abs(east - west);
            int steps = i + 1;
            int possibleDist = Math.min(steps, MD + 2 * k);
            maxDist = Math.max(maxDist, possibleDist);
        }

        return maxDist;
    }
}
