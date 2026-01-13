class Solution {
    public int countNegatives(int[][] grid) {
        int count = 0;
        int cols = grid[0].length;
        
        for (int[] row : grid) {
            int left = 0, right = cols - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (row[mid] < 0) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            count += cols - left;
        }
        
        return count;
        /*
        int count = 0;  
        for (int i = 0; i < grid.length; i++) {  
            for (int j = 0; j < grid[i].length; j++) { 
                if (grid[i][j] < 0) {  
                    count++;  
                }
            }
        }
        return count;
        */
    }
}
