import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[][] lines = new int[n][2];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lines[i][0] = Integer.parseInt(st.nextToken());
			lines[i][1] = Integer.parseInt(st.nextToken());
		}

		br.close();

		Arrays.sort(lines, (o1, o2) -> {
			if (o1[0] == o2[0]) return o2[1]-o1[1];
			return o1[0] - o2[0];
		});


		// System.out.println(Arrays.deepToString(lines));
		int[] last = Arrays.copyOf(lines[0], lines[0].length);
		int length = lines[0][1]-lines[0][0];

		int beforeStartPoint = lines[0][0];

		for (int i = 1; i < lines.length; i++) {
			if (beforeStartPoint == lines[i][0]) continue; // 시작점이 같으면 갱신할 필요 X
			if (last[0] <= lines[i][0] && last[1] >= lines[i][1]) continue;

			if (last[1] > lines[i][0]) { // 중복으로 선을 놓는데 연장될 때	 
				beforeStartPoint = lines[i][0];
				length += lines[i][1]-last[1];
				last[1] = lines[i][1];
			} else { // 중복되게 선을 긋지 않을 때
				beforeStartPoint = lines[i][0];
				length += lines[i][1] - lines[i][0];
				last = Arrays.copyOf(lines[i], lines[i].length);
			}
		}
		System.out.println(length);
	}
}

/*

4
-1000000000 1000000000
1 5
3 5
6 7

*/