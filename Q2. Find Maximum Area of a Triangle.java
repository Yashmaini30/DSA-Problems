import java.util.HashMap;
import java.util.Map;

class Solution {
    public long maxArea(int[][] coords) {
        Map<Integer, int[]> xg = new HashMap<>();
        Map<Integer, int[]> yg = new HashMap<>();
        long lx = Long.MAX_VALUE, rx = Long.MIN_VALUE;
        long ly = Long.MAX_VALUE, ry = Long.MIN_VALUE;
        
        for (int[] p : coords) {
            int x = p[0], y = p[1];
            
            xg.putIfAbsent(x, new int[]{y, y});
            int[] yr = xg.get(x);
            yr[0] = Math.min(yr[0], y);
            yr[1] = Math.max(yr[1], y);
            
            yg.putIfAbsent(y, new int[]{x, x});
            int[] xr = yg.get(y);
            xr[0] = Math.min(xr[0], x);
            xr[1] = Math.max(xr[1], x);
            
            lx = Math.min(lx, x);
            rx = Math.max(rx, x);
            ly = Math.min(ly, y);
            ry = Math.max(ry, y);
        }
        
        long ans = 0;
        
        for (Map.Entry<Integer, int[]> e : xg.entrySet()) {
            long w = (long) e.getValue()[1] - e.getValue()[0];
            if (w == 0) continue;
            long h = Math.max(e.getKey() - lx, rx - e.getKey());
            if (h > 0)
                ans = Math.max(ans, w * h);
        }
        
        for (Map.Entry<Integer, int[]> e : yg.entrySet()) {
            long w = (long) e.getValue()[1] - e.getValue()[0];
            if (w == 0) continue;
            long h = Math.max(e.getKey() - ly, ry - e.getKey());
            if (h > 0)
                ans = Math.max(ans, w * h);
        }
        
        return ans > 0 ? ans : -1;
    }
}
