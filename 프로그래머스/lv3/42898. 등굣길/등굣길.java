class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] grid = new int[m+1][n+1];
        
        for(int i = 1; i < m+1; i++) {
            for(int j = 1; j < n+1; j++) {
                boolean isPuddle = false;
                for(int[] puddle : puddles) {
                    if (puddle[0] == i && puddle[1] == j)
                        isPuddle = true;
                }
                if (isPuddle) continue;
                
                if (i == 1 && j == 1) grid[i][j] = 1;
                else grid[i][j] = (grid[i-1][j] + grid[i][j-1])%1000000007;
            }
        }
        
        return grid[m][n];
    }
}