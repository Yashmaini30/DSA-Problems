class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int d = -(n - 1); d <= (n - 1); d++) {
            List<Integer> diag = new ArrayList<>();

            for (int r = 0; r < n; r++) {
                int c = r - d;
                if (c >= 0 && c < n) {
                    diag.add(grid[r][c]);
                }
            }

            if (d >= 0) {
                diag.sort(Collections.reverseOrder()); 
            } else {
                Collections.sort(diag);
            }
            int idx = 0;
            for (int r = 0; r < n; r++) {
                int c = r - d;
                if (c >= 0 && c < n) {
                    grid[r][c] = diag.get(idx++);
                }
            }
        }

        return grid;
    }
}
