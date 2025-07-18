import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] grid;
    static List<Point> virus = new ArrayList<>();
    static int maxSafeAreaCount = 0;
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int N, M;

    public static void main(String[] args) throws IOException {
        //인체에 치명적인 바이러스를 연구하던 연구소에서 바이러스가 유출되었다. 다행히 바이러스는 아직 퍼지지 않았고, 바이러스의 확산을 막기 위해서 연구소에 벽을 세우려고 한다.
        //
        //연구소는 크기가 N×M인 직사각형으로 나타낼 수 있으며, 직사각형은 1×1 크기의 정사각형으로 나누어져 있다. 연구소는 빈 칸, 벽으로 이루어져 있으며, 벽은 칸 하나를 가득 차지한다.
        //
        //일부 칸은 바이러스가 존재하며, 이 바이러스는 상하좌우로 인접한 빈 칸으로 모두 퍼져나갈 수 있다. 새로 세울 수 있는 벽의 개수는 3개이며, 꼭 3개를 세워야 한다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 2) virus.add(new Point(i, j));
            }
        }

        setWall(0, 0);

        System.out.println(maxSafeAreaCount);
    }

    public static void setWall(int wallCnt, int start) {
        if (wallCnt == 3) {
            maxSafeAreaCount = Math.max(maxSafeAreaCount, getSafeAreaCnt());
            return;
        }

        for (int i = start; i < N * M; i++) {
            int r = i / M;
            int c = i % M;

            if (grid[r][c] == 0) {
                grid[r][c] = 1;
                setWall(wallCnt + 1, i + 1);
                grid[r][c] = 0;
            }
        }
    }

    public static int getSafeAreaCnt() {

        // grid 복사
        int[][] gridCopy = new int[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            gridCopy[i] = Arrays.copyOf(grid[i], grid[i].length);
        }

        // bfs
        Queue<Point> q = new LinkedList<>(virus);

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int[] d : delta) {
                Point next = new Point(now.x + d[0], now.y + d[1]);

                if (0 <= next.x && next.x < grid.length && 0 <= next.y && next.y < grid[0].length && gridCopy[next.x][next.y] == 0) {
                    q.add(next);
                    gridCopy[next.x][next.y] = 2;
                }
            }
        }

        int safeAreaCnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (gridCopy[i][j] == 0) safeAreaCnt++;
            }
        }

        return safeAreaCnt;
    }
}
