class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int groups = (n + k - 1)/k;
        String[] res = new String[groups];

        for(int i=0; i < groups; i++){
            StringBuilder group = new StringBuilder();
            for(int j=0; j < k; j++){
                int ind = i*k + j;
                if (ind < n){
                    group.append(s.charAt(ind));
                }else{
                    group.append(fill);
                }

            }
            res[i] = group.toString();
        }
        return res;
    }
}
