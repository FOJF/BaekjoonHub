import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int m = maps.length;
        int n = maps[0].length;
        
        int[][] dist = new int[m][n];
        Queue<int[]> q = new ArrayDeque<>();
        
        q.add(new int[]{0,0});
        dist[0][0] = 1;
        
        int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int[] dir : delta) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                
                if (0 <= nx && nx < m && 0 <= ny && ny < n && dist[nx][ny] == 0 && maps[nx][ny] != 0) {
                    if (nx == m-1 && ny == n-1) return dist[cur[0]][cur[1]]+1;
                    
                    q.add(new int[]{nx, ny});
                    dist[nx][ny] = dist[cur[0]][cur[1]]+1;
                }
            }
        }
        
        return -1;
    }
}