import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		br.readLine();

		int[] S = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		Set<Integer> sums = new HashSet<>();

		bt(S, sums, 0);

		int N = Arrays.stream(S).sum();

		for(int i = 1; i <= N+1; i++) {
			if (!sums.contains(i)) {
				System.out.println(i);
				break;
			}
		}
	}

	private static int sum = 0;

	public static void bt(int[] S, Set<Integer> sums, int start) {
		for (int i = start; i < S.length; i++) {
			sum += S[i];
			sums.add(sum);
			bt(S, sums, i+1);
			sum -= S[i];
		}
	}
}