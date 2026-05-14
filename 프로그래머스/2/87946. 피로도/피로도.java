import java.util.*;
class Solution {
    public int solution(int k, int[][] dungeons) {
        dfs(k, dungeons, new boolean[k], 0);
        
        return answer;
    }
    
    private int answer = 0;
    private void dfs(int k, int[][] dungeons, boolean[] visited, int depth) {
        answer = Math.max(answer, depth);
        
        for(int i = 0; i < dungeons.length; i++) {
            if (visited[i] || dungeons[i][0] > k) continue;
            
            visited[i] = true;
            dfs(k-dungeons[i][1], dungeons, visited, depth+1);
            visited[i] = false;
        }
    }
}