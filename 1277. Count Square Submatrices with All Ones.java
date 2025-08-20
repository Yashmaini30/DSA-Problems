class Solution { 
    public int countSquares(int[][] matrix) {
        int res = 0;
        int n = matrix.length;
        int m = matrix[0].length; 

        for (int j = 0; j < m; j++) {
            res += matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            res += matrix[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 1) {
                    int up  = matrix[i - 1][j];
                    int left = matrix[i][j - 1];
                    int dia  = matrix[i - 1][j - 1];

                    int val = Math.min(up, Math.min(left, dia)) + 1; 
                    matrix[i][j] = val;
                    res += val;
                }
            }
        }
        return res;
    }
}
