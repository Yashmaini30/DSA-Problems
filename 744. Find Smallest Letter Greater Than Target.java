class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length - 1;
        int res = 0;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (letters[mid] > target) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return letters[res];
    }
}
