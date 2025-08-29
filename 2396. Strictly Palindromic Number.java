class Solution {
    public boolean isStrictlyPalindromic(int n) {
        // For n >= 4, in base (n-2) representation is always "12" (not a palindrome).
        // Hence no number >= 4 is strictly palindromic.
        return false;
    }
}
