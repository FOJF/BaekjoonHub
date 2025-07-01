import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static final int INF = 200_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(b, w));
            graph.get(b).add(new Edge(a, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        br.close();

        // 다익스트라 3회 실행
        int[] distFrom1 = dijkstra(1, n, graph);
        int[] distFromV1 = dijkstra(v1, n, graph);
        int[] distFromV2 = dijkstra(v2, n, graph);

        long path1 = (long)distFrom1[v1] + distFromV1[v2] + distFromV2[n];
        long path2 = (long)distFrom1[v2] + distFromV2[v1] + distFromV1[n];

        long ans = Math.min(path1, path2);
        System.out.println(ans >= INF ? -1 : ans);
    }

    static int[] dijkstra(int start, int n, List<List<Edge>> graph) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        boolean[] visited = new boolean[n + 1];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], d = cur[1];
            if (visited[u]) continue;
            visited[u] = true;

            for (Edge e : graph.get(u)) {
                int v = e.to, w = e.weight;
                if (dist[v] > d + w) {
                    dist[v] = d + w;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }
        return dist;
    }
}
