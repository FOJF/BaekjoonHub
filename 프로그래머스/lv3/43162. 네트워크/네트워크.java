import java.util.*;

class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> bfsQ = new ArrayDeque<>();
        
        for(int i = 0; i < n; i++) {
            if (visited[i]) continue;
            
            answer++;
            visited[i] = true;
            bfsQ.add(i);
            
            while(!bfsQ.isEmpty()) {
                int cur = bfsQ.poll();
                for(int j = 0; j < computers.length; j++) {
                    if (visited[j] || computers[cur][j] == 0) continue;
                    
                    bfsQ.add(j);
                    visited[j] = true;
                }
            }
        }
        
        return answer;
    }
}