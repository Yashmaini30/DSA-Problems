class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = new int[n]; 
        int[] nse = new int[n]; 
        Stack<Integer> s = new Stack<>();

        // Calculate previous smaller elements
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                pse[i] = -1; // No smaller element to the left
            } else {
                pse[i] = s.peek();
            }
            s.push(i);
        }

        s.clear();

        // Calculate next smaller elements
        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            if (s.isEmpty()) {
                nse[i] = n; // No smaller element to the right
            } else {
                nse[i] = s.peek();
            }
            s.push(i);
        }
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        
    }
}
