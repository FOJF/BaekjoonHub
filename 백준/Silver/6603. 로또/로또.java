import java.io.*;
import java.util.*;

public class Main {

	static int[] numbers;
	static List<int[]> combinations;
	static int[] temp;
	static int tempIdx = 0;

	final static int MAX_CNT = 6;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			if (k == 0) break;
	
			numbers = new int[k];
	
			for (int i = 0; i < numbers.length; i++) {
				numbers[i] = Integer.parseInt(st.nextToken());
			}
	
			Arrays.sort(numbers);
			
			temp = new int[MAX_CNT];
	
			combinations = new ArrayList<>();
	
			pickLotterys(0);
	
			for (int i = 0; i < combinations.size(); i++) {
				for (int j = 0; j < combinations.get(i).length; j++) {
					sb.append(combinations.get(i)[j]).append(" ");
				}
				sb.append("\n");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		br.close();
	}


	public static void pickLotterys(int start) {
		if (tempIdx == MAX_CNT) {
			combinations.add(Arrays.copyOf(temp, temp.length));
			return;
		}

		for (int i = start; i < numbers.length; i++) {
			temp[tempIdx++] = numbers[i];
			pickLotterys(i+1);
			tempIdx--;
		}
	}
}