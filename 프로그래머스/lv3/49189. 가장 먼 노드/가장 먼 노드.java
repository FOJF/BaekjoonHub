import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> adj = new ArrayList<>();
        
        for(int i = 0; i < n+1; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(int[] e : edge) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        
        int[] dist = new int[n+1];
        
        Queue<Integer> q = new ArrayDeque<>();
        
        q.add(1);
        dist[1] = 1;
        
        int answer = 1;
        int max = 1;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for(int next : adj.get(cur)) {
                if (dist[next] != 0) continue;
                
                q.add(next);
                dist[next] = dist[cur]+1;
                
                if (max < dist[next]) {
                    max = dist[next];
                    answer = 1;
                } else if (max == dist[next]) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}