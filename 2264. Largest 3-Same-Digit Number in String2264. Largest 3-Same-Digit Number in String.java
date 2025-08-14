class Solution {
    public String largestGoodInteger(String num) {
        // for(char c= '9'; c >= '0'; c--){
        //     String triple = "" + c + c +c;

        String[] numbers = { "999", "888", "777", "666", "555", "444", "333", "222", "111", "000" };
        for (String i : numbers) {
            if (num.contains(i)) {
                return i;
            }
        }
        return "";
    }
}
