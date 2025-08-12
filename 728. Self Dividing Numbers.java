class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> res = new ArrayList<>();

        for(int i=left; i <= right; i++){
            if(CheckSelfDivide (i)){
                res.add(i);
            }
        }
        return res;    
    }

    private boolean CheckSelfDivide(int num){
        int org = num;
        while(num > 0){
            int digit = num % 10;
            if(digit == 0 || org % digit != 0){
                return false;
            }
            num = num/10;
        }
        return  true;
    }
}
