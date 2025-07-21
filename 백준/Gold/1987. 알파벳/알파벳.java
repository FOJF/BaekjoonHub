import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static char[][] map;
    static boolean[][] visited;
    static HashSet<Character> set = new HashSet<>();
    static int[][] delta = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    static int answer = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        bt(0, 0);

        System.out.println(answer);
    }


    public static void bt(int x, int y) {
//        System.out.println(set);
        if (set.contains(map[x][y])) {
            answer = Math.max(answer, set.size());
            return;
        }

        set.add(map[x][y]);

        for (int[] dir : delta) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;

            bt(nx, ny);
        }

        set.remove(map[x][y]);
    }
}
