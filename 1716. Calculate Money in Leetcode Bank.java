class Solution {
    public int totalMoney(int n) {
        
        int complete = n/7;
        int rem = n%7;

        int part1 = (28*complete) + (7*(complete-1)*(complete))/2;
        int part2 = rem*(rem+1)/2 + complete*rem;

        return part1 + part2;
    }
}
