import java.util.*;

class Solution {
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int cx = characterX << 1, cy = characterY << 1;
        int ix = itemX << 1, iy = itemY << 1;
        
        int[][] grid = new int[101][101];
        
        for(int[] rect : rectangle) {
            int x1 = rect[0] << 1, y1 = rect[1] << 1;
            int x2 = rect[2] << 1, y2 = rect[3] << 1;
            
            for(int i = x1; i <= x2; i++) {
                for(int j = y1; j <= y2; j++) {
                    if (grid[i][j] != 2 && (i == x1 || i == x2 || j == y1 || j == y2)) grid[i][j] = 1;
                    else grid[i][j] = 2;
                }
            }
        }
        
        Queue<int[]> q = new ArrayDeque<>();
        int[][] dist = new int[grid.length][grid.length];
        
        q.add(new int[]{cx, cy});
        dist[cx][cy] = 1;
        
        int[][] delta = {{0, 1},{0, -1},{-1, 0},{1, 0}};
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int[] dir : delta) {
                int nx = cur[0] + dir[0];
                int ny = cur[1] + dir[1];
                
                if (0<=nx && nx<grid.length && 0<=ny && ny<grid.length && dist[nx][ny] == 0 && grid[nx][ny] == 1) {
                    if (nx == ix && ny == iy) return dist[cur[0]][cur[1]]>>1;
                    q.add(new int[]{nx, ny});
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                }
            }
        }
        
        return -1;
    }
}