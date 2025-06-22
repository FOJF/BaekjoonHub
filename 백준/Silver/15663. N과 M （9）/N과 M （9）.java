import java.io.*;
import java.util.*;

public class Main {

	static int[] numbers;
	static boolean[] isPicked;
	static Set<String> answer = new LinkedHashSet<>();
	static List<Integer> temp = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] nm = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		numbers = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		br.close();

		Arrays.sort(numbers);
		isPicked = new boolean[numbers.length];

		getAnswer(0,nm[1]);
			
		StringBuilder sb = new StringBuilder();

		for (String s : answer) {
			sb.append(s).append("\n");
		}

		System.out.println(sb);
	}

	public static void getAnswer(int start, int length) {
		if (temp.size() == length) {
			StringBuilder sb = new StringBuilder();

			for (int num : temp) {
				sb.append(num).append(" ");
			}

			answer.add(sb.toString());
			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (isPicked[i]) continue;

			temp.add(numbers[i]);
			isPicked[i] = true;
			getAnswer(i+1, length);
			isPicked[i] = false;
			temp.remove(temp.size()-1);
		}
 	}
}