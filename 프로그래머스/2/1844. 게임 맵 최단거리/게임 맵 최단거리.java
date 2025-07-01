import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int[][] delta = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        
        int[][] distance = new int[maps.length][maps[0].length];
        
        Queue<int[]> q = new LinkedList<>();
        
        q.add(new int[]{0,0});
        distance[0][0] = 1;
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            
            int x = now[0];
            int y = now[1];
            
            if (x == maps.length-1 && y == maps[x].length-1) return distance[x][y];
            
            for (int[] dir : delta) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                
                if ((0 <= nx && nx < maps.length) && (0 <= ny && ny < maps[nx].length) 
                    && maps[nx][ny] == 1
                    && distance[nx][ny] == 0) {
                    q.add(new int[]{nx,ny});
                    distance[nx][ny] = distance[x][y] + 1;
                }
            }
        }
        
        System.out.println(Arrays.deepToString(distance));
        
        return -1;
    }
}
/*
	[[1, 0, 1, 1, 1],
     [1, 0, 1, 0, 1],
     [1, 0, 1, 1, 1],
     [1, 1, 1, 0, 1],
     [0, 0, 0, 0, 1]]

[[1, 0, 9, 10, 0],
 [2, 0, 8, 0, 0],
 [3, 0, 7, 8, 0],
 [4, 5, 6, 0, 0],
 [0, 0, 0, 0, 0]]

*/