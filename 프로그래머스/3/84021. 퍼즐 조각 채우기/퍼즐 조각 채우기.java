import java.util.*;

class Solution {
    private int[][] delta = {{0,1},{0,-1},{1,0},{-1,0}};
    public int solution(int[][] game_board, int[][] table) {
        int answer = 0;
        
        for(int r = 0; r < 4; r++) {
            game_board = rotate(game_board);
            for(int i = 0; i < game_board.length; i++) {
                for(int j = 0; j < game_board.length; j++) {
                    if (game_board[i][j] == 1) continue;

                    for(int k = 0; k < table.length; k++) {
                        for(int l = 0; l < table.length; l++) {
                            if (table[k][l] == 0) continue;

                            if (isSame(game_board, i, j, table, k, l)) {
                                answer += paint(game_board, i, j);
                                paint(table, k, l);

                                k = Integer.MAX_VALUE-1;
                                l = Integer.MAX_VALUE-1;
                            }
                        }
                    }
                }
            }
        }
        
        return answer;
    }
    
    private int paint(int[][] grid, int x, int y) {
        int start = grid[x][y];
        
        Queue<int[]> q = new ArrayDeque<>();
        
        int painted = 1;
        
        q.add(new int[]{x,y});
        grid[x][y] = start == 0 ? 1 : 0;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            
            for(int[] dir : delta) {
                int[] next = {cur[0] + dir[0], cur[1] + dir[1]};
                if (0 <= next[0] && next[0] < grid.length
                   && 0 <= next[1] && next[1] < grid.length && grid[next[0]][next[1]] == start) {
                    q.add(next);
                    grid[next[0]][next[1]] = start == 0 ? 1 : 0;
                    painted++;
                }
            }
        }
        return painted;
    }
    
    private boolean isSame(int[][] grid1, int x1, int y1, int[][] grid2, int x2, int y2) {
        Queue<int[]> q1 = new ArrayDeque<>();
        Queue<int[]> q2 = new ArrayDeque<>();
        
        boolean[][] visited1 = new boolean[grid1.length][grid1.length];
        boolean[][] visited2 = new boolean[grid2.length][grid2.length];
        
        q1.add(new int[] {x1, y1});
        visited1[x1][y1] = true;
        q2.add(new int[] {x2, y2});
        visited2[x2][y2] = true;
        
        while(!q1.isEmpty() && !q2.isEmpty()) {
            int[] cur1 = q1.poll();
            int[] cur2 = q2.poll();
            
            if (cur1[0]-x1 != cur2[0]-x2 || cur1[1]-y1 != cur2[1]-y2) return false;
            
            for(int[] dir : delta) {
                int[] next1 = { cur1[0] + dir[0], cur1[1] + dir[1] };
                int[] next2 = { cur2[0] + dir[0], cur2[1] + dir[1] };
                
                if (0 <= next1[0] && next1[0] < grid1.length && 0 <= next1[1] && next1[1] < grid1.length &&
                    grid1[next1[0]][next1[1]] == 0 && !visited1[next1[0]][next1[1]] ) {
                    
                    q1.add(next1);
                    visited1[next1[0]][next1[1]] = true;
                }

                if (0 <= next2[0] && next2[0] < grid2.length && 0 <= next2[1] && next2[1] < grid2.length &&
                    grid2[next2[0]][next2[1]] == 1 && !visited2[next2[0]][next2[1]]) {
                    
                    q2.add(next2);
                    visited2[next2[0]][next2[1]] = true;
                }
            }
        }
        
        if (!q1.isEmpty() || !q2.isEmpty()) return false;
        
        return true;
    }
    
    private int[][] rotate(int[][] grid) {
        int[][] nGrid = new int[grid.length][grid.length];
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid.length; j++) {
                nGrid[i][j] = grid[grid.length-j-1][i];
            }
        }
        return nGrid;
    }
    
    private String toString(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        
        for(int[] gr : grid) {
            for(int g : gr) {
                sb.append(g).append(" ");
            }
            sb.append("\n");
        }
        
        return sb.toString();
    }
}