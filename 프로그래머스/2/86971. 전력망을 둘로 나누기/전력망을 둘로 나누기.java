import java.util.*;

class Solution {
    public int solution(int n, int[][] wires) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            adj.get(wire[0]).add(wire[1]);
            adj.get(wire[1]).add(wire[0]);
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        int answer = Integer.MAX_VALUE;
        
        for(int[] wire : wires) {
            boolean[] visited = new boolean[n+1];
            int from = wire[0];
            int to = wire[1];
            
            int cnt = 0;
            
            q.add(from);
            visited[from] = true;

            while(!q.isEmpty()) {
                int cur = q.poll();
                cnt++;

                for(int next : adj.get(cur)) {
                    if (visited[next] || (cur == from && next == to)) continue;

                    q.add(next);
                    visited[next] = true;
                }
            }
            
            answer = Math.min(answer, Math.abs(cnt*2-n));
        }
        return answer;
    }
}