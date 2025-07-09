import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                grid[i][j] = sc.nextInt();
        // Please write your code here.

        int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0,0});
        visited[0][0] = true;


        while(!q.isEmpty()) {
            int[] now = q.poll();

            for(int[] dir : delta) {
                int nx = now[0] + dir[0];
                int ny = now[1] + dir[1];

                if (0<= nx && nx < n && 0<= ny && ny < m && !visited[nx][ny] && grid[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                }
            }
        }

        System.out.println(visited[n-1][m-1] ? "1" : "0");
    }
}