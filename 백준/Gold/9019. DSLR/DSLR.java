import java.io.*;
import java.util.*;

public class Main {
	static final int MAX_VALUE = 10000;
	static final char[] CMD = { 'D', 'S', 'L', 'R' };
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		Queue<Integer> bfsQ = new ArrayDeque<>();

		StringBuilder sb = new StringBuilder();

		while(T-- > 0) {
			int[] visited = new int[MAX_VALUE];
			StringTokenizer st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			bfsQ.add(A);
			visited[A] = -1;

			while(!bfsQ.isEmpty()) {
				int cur = bfsQ.poll();

				if (cur == B) {
					bfsQ.clear();
					int r = B;
					StringBuilder ssb = new StringBuilder();
					while(visited[r] != -1) {
						ssb.append(CMD[visited[r]%10]);
						r = visited[r]/10;
					}
					sb.append(ssb.reverse()).append("\n");
					break;
				}

				int[] next = {
					(cur << 1) % MAX_VALUE,
					cur==0 ? MAX_VALUE-1 : cur-1,
					cur/(MAX_VALUE/10) + cur%(MAX_VALUE/10)*10,
					cur%10*(MAX_VALUE/10) + cur/10
				};

				for(int i = 0; i < next.length; i++) {
					if (visited[next[i]] != 0) continue;

					bfsQ.add(next[i]);
					visited[next[i]] = cur*10 + i;
				}
			}
		}
		System.out.println(sb);
	}
}