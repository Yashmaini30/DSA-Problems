class Solution {
    public boolean isValidSudoku(char[][] board) {

        boolean[][] rows = new boolean[9][9];
        boolean[][] cols = new boolean[9][9];
        boolean[][] boxes = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;  

                int num = c - '1';  // convert '1'..'9' → 0..8
                int box = (i / 3) * 3 + (j / 3);  // box index: 0..8

                if (rows[i][num] || cols[j][num] || boxes[box][num]) {
                    return false;
                }
                rows[i][num] = true;
                cols[j][num] = true;
                boxes[box][num] = true;
            }
        }
        /* HashSet seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (!seen.add("row" + i + board[i][j]) || !seen.add("col" + j + board[i][j])){
                        return false;
                    }
                    if (!seen.add("box" + (i / 3) * 3 + j / 3 + board[i][j])) {
                        return false;
                    }

                }

            }
        }*/
        return true;
    }
}
