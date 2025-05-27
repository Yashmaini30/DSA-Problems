class Solution {
    public int differenceOfSums(int n, int m) {
        // int num1 = 0, num2 = 0;
        // for (int i=1;i<=n;i++){
        //     if(i%m == 0) num2 +=i;
        //     else num1 += i;
        // }
        // return num1 - num2;

        int sum = n*(n+1)/2;
        int div = n/m;
        int divSum = m*div*(div+1)/2;

        return sum - 2*divSum;
        
    }
}
