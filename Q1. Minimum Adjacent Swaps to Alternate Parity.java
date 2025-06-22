import java.util.*;

class Solution {
    int countSwaps(int[] pos, int[] tg) {
        int sw = 0;
        for (int i = 0; i < pos.length; i++) {
            sw += Math.abs(pos[i] - tg[i]);
        }
        return sw;
    }
    
    public int minSwaps(int[] a) {
        List<Integer> ep = new ArrayList<>();
        List<Integer> op = new ArrayList<>();
        int n = a.length;
        
        for (int i = 0; i < n; i++) {
            if (a[i] % 2 == 0) ep.add(i);
            else op.add(i);
        }
        
        int ec = ep.size(), oc = op.size();
        if (Math.abs(ec - oc) > 1) return -1;
        
        int res = Integer.MAX_VALUE;
        
        if (ec >= oc) {
            int[] tg = new int[ec];
            for (int i = 0; i < ec; i++) tg[i] = 2 * i;
            res = Math.min(res, countSwaps(ep.stream().mapToInt(i -> i).toArray(), tg));
        }

        if (oc >= ec) {
            int[] tg = new int[oc];
            for (int i = 0; i < oc; i++) tg[i] = 2 * i;
            res = Math.min(res, countSwaps(op.stream().mapToInt(i -> i).toArray(), tg));
        }
        
        return res;
    }
}
