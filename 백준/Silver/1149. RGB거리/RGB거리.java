import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		for (int i = 0; i < n-1; i++) {
			int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] newCosts = new int[3];

			for (int j = 0; j < 3; j++) {
				int min = switch(j) {
					case 0 -> Math.min(costs[1], costs[2]);
					case 1 -> Math.min(costs[0], costs[2]);
					case 2 -> Math.min(costs[0], costs[1]);
					default -> 0;
				};
				newCosts[j] = min + input[j];
			}

			costs = Arrays.copyOf(newCosts, newCosts.length);
		}

		br.close();
		System.out.println(Arrays.stream(costs).min().getAsInt());
	}
}