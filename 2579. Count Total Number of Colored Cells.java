class Solution {
    public long coloredCells(int n) {
        long res=n;
        return 1 + 2 * res * (res-1);
    }
}
