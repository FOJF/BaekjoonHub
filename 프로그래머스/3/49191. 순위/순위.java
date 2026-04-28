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
        
        
        
        List<Set<Integer>> from = new ArrayList<>();
        // List<Set<Integer>> to = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            from.add(new HashSet<>());
            // to.add(new HashSet<>());
        }
        
        
        
        
        for(int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n+1];
            dfs(i, i, adj, visited, from);
        }
        
        
        
        for(Set<Integer> s : from)
            System.out.println(s);
        
        int answer = 0;
        for(int i = 1; i <= n; i++) {
            if(from.get(i).size() == n) answer++;
        }
        return answer;
    }
    
    
    private void dfs(int start, int cur, List<Set<Integer>> adj, boolean[] visited, List<Set<Integer>> from) {
        if (visited[cur]) return;
        visited[cur] = true;
        
        from.get(start).add(cur);
        from.get(cur).add(start);
        // if (visited.contains(cur)) return;
        // System.out.println(cur);
        // visited.add(cur);
        
        for (int next : adj.get(cur)) {
            dfs(start, next, adj, visited, from);
        }
        
    }
}