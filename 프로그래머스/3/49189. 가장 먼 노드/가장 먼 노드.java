import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
        int[] distance = new int[n+1];
        
        List<List<Integer>> adjList = new ArrayList<>();
        
        for (int i = 0; i < n+1; i++) {
            adjList.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        int max = 0;
        
        q.add(1);
        distance[1] = 1;
        
        while(!q.isEmpty()) {
            int now = q.poll();
            
            for (int next : adjList.get(now)) {
                if (distance[next] != 0) continue;
                
                q.add(next);
                distance[next] = distance[now] + 1;
                max = Math.max(max, distance[next]);
            }
        }
        int m = max;
        return (int)Arrays.stream(distance).filter(i -> i == m).count();
    }
}