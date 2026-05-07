import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adj.add(new HashSet<>());
        }
        for(int i = 0; i < results.length; i++) {
            adj.get(results[i][0]).add(results[i][1]);
        }
        
        List<Set<Integer>> known = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            known.add(new HashSet<>());
        }
        
        for(int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            dfs(i, i, adj, visited, known);
        }
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(known.get(i).size() == n) answer++;
        }
        return answer;
    }
    
    
    private void dfs(int start, int cur, List<Set<Integer>> adj, boolean[] visited, List<Set<Integer>> known) {
        if (visited[cur]) return;
        visited[cur] = true;
        
        known.get(start).add(cur);
        known.get(cur).add(start);
        
        for (int next : adj.get(cur)) {
            dfs(start, next, adj, visited, known);
        }
    }
}