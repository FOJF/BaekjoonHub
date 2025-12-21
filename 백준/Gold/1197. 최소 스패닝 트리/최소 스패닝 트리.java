import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] VE = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		boolean[] visited = new boolean[VE[0]+1];

		List<List<int[]>> adj = new ArrayList<>();
		for (int i = 0; i < VE[0]+1; i++) {
			adj.add(new ArrayList<>());
		}

		for (int i = 0; i < VE[1]; i++) {
			int[] eInfo = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			adj.get(eInfo[0]).add(new int[]{eInfo[1], eInfo[2]});
			adj.get(eInfo[1]).add(new int[]{eInfo[0], eInfo[2]});
		}

		Queue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

		pq.add(new int[]{1, 0});
		
		int answer = 0;

		while(!pq.isEmpty()) {
			int[] edge = pq.poll();

			if (visited[edge[0]]) continue;

			visited[edge[0]] = true;
			answer += edge[1];

			for(int[] e : adj.get(edge[0])) {
                if (visited[e[0]]) continue;
				pq.add(e);
			}
		}

		System.out.println(answer);
	}
}