public class Solution {
    private int time = 0;
    private List<List<Integer>> result;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (List<Integer> conn : connections) {
            int u = conn.get(0);
            int v = conn.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        result = new ArrayList<>();
        int[] disc = new int[n]; 
        int[] low = new int[n];
        Arrays.fill(disc, -1);

        dfs(0, -1, graph, disc, low);

        return result;
    }

    private void dfs(int u, int parent, List<List<Integer>> graph, int[] disc, int[] low) {
        disc[u] = low[u] = ++time;

        for (int v : graph.get(u)) {
            if (v == parent) continue; 

            if (disc[v] == -1) {
                dfs(v, u, graph, disc, low);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
