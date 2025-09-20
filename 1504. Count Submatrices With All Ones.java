class Solution {
    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        for (int r = 1; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] == 1) {
                    mat[r][c] += mat[r - 1][c];
                }
            }
        }

        int res = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (mat[r][c] > 0) {
                    int min_h = mat[r][c];
                    for (int k = c; k >= 0; k--) {
                        if (mat[r][k] == 0) break;
                        min_h = Math.min(min_h, mat[r][k]);
                        res += min_h;
                    }
                }
            }
        }

        return res;
    }
}
