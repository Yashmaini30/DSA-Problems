class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] freq = new int[10];
        for(int d: digits) freq[d]++;

        List <Integer> res = new ArrayList<>();
        for(int i=100;i<=998;i += 2){
            int a = i/100;
            int b = (i/10) % 10;
            int c = i % 10;

            int[] local = new int[10];
            local[a]++;
            local[b]++;
            local[c]++;

            boolean valid = true;
            for (int d = 0; d < 10; d++) {
                if (local[d] > freq[d]) {
                    valid = false;
                    break;
                }
            }
            if (valid) res.add(i);
        }
        return res.stream().mapToInt(i -> i).toArray();

    }
}
