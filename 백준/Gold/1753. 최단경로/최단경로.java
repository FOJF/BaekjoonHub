import java.io.*;
import java.util.*;

public class Main {
    // 가독성을 위한 Node 클래스 정의
    static class Node implements Comparable<Node> {
        int idx, dist;
        Node(int idx, int dist) {
            this.idx = idx;
            this.dist = dist;
        }
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        int start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
        }

        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            // 이미 더 짧은 경로로 방문했다면 패스
            if (dist[now.idx] < now.dist) continue;

            for (Node next : graph.get(now.idx)) {
                if (dist[next.idx] > now.dist + next.dist) {
                    dist[next.idx] = now.dist + next.dist;
                    pq.offer(new Node(next.idx, dist[next.idx]));
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            sb.append(dist[i] == Integer.MAX_VALUE ? "INF" : dist[i]).append('\n');
        }
        System.out.print(sb);
    }
}
