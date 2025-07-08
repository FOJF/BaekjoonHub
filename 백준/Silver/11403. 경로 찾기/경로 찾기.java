import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        boolean[][] ways = new boolean[n][n];

        // 인접 행렬 입력
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ways[i][j] = input[j].equals("1");
            }
        }

        // 플로이드-워셜 알고리즘
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ways[i][k] && ways[k][j]) {
                        ways[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(ways[i][j] ? "1 " : "0 ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
