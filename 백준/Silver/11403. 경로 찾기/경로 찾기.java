import java.io.*;
import java.util.*;

public class Main {

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // 정점(노드) 개수 입력 받기

        boolean[][] ways = new boolean[n][n]; // 인접 행렬(그래프의 연결 정보 저장)

        // 인접 행렬 입력 받기
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                ways[i][j] = (input[j].charAt(0) == '1'); // '1'이면 연결, '0'이면 미연결
            }
        }

        br.close();

        boolean[][] answer = new boolean[n][n]; // 결과를 저장할 배열

        // 모든 정점 쌍에 대해 경로 존재 여부 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                answer[i][j] = isPossible(ways, i, j); // i에서 j로 갈 수 있으면 1, 없으면 0
            }
        }

        StringBuilder sb = new StringBuilder();

        // 결과 출력
        for (boolean[] arr : answer) {
            for (boolean bool : arr) {
                sb.append(bool?'1':'0').append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    // ways: 인접 행렬, start: 시작 정점, end: 도착 정점
    public static boolean isPossible(boolean ways[][], int start, int end) {
        Queue<Integer> bfsQ = new LinkedList<>(); // BFS를 위한 큐
        boolean[] isVisited = new boolean[ways.length]; // 방문 체크 배열
        bfsQ.offer(start); // 시작 노드를 큐에 넣음

        while (!bfsQ.isEmpty()) {
            int vertex = bfsQ.poll(); // 큐에서 노드 꺼내기

            for (int i = 0; i < ways[vertex].length; i++) {
                // ways[vertex][i]가 true이고, 아직 방문하지 않았다면
                if (ways[vertex][i] && !isVisited[i]) {
                    if (i == end) return true; // 도착 정점에 도달하면 1 반환
                    bfsQ.offer(i); // 다음 노드 큐에 추가
                    isVisited[i] = true; // 방문 처리
                }
            }
        }
        return false; // 경로가 없다면 0 반환
    }
}

