import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int[][] starts = new int[k][2];
        for (int i = 0; i < k; i++) {
            starts[i][0] = sc.nextInt()-1;
            starts[i][1] = sc.nextInt()-1;
        }
        // Please write your code here.

        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();

        int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

        int answer = 0;

        for(int[] start : starts) {
            if (visited[start[0]][start[1]]) continue;

            q.add(start);
            visited[start[0]][start[1]] = true;
            answer++;

            while(!q.isEmpty()) {
                int[] now = q.poll();

                for(int[] dir : delta) {
                    int nx = now[0] + dir[0];
                    int ny = now[1] + dir[1];

                    if (0<=nx && nx<n && 0<=ny && ny<n && !visited[nx][ny] && grid[nx][ny]==0) {
                        q.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}