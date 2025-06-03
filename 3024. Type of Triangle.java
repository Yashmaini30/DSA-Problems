class Solution {
    public String triangleType(int[] nums) {
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];

        boolean isValidTriangle = (a + b > c) && (b + c > a) && (a + c > b);

        if (a == b && b == c) return "equilateral";

        if (isValidTriangle) {
            if (a == b || b == c || a == c) return "isosceles";
            else return "scalene";
        }

        return "none";
    }
}3024. Type of Triangle
