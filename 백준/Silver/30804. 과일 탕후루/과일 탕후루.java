import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] fruits = new int[n];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			fruits[i] = Integer.parseInt(st.nextToken());
		}

		br.close();

		int[] check = new int[10];

		int answer = 1;

		int l = 0;
		int r = 1;

		check[fruits[l]]++;

		while(l < r && r < n) {
			check[fruits[r++]]++;

			int fruitSorts = 0;

			for(int i = 1; i < check.length; i++) {
				if (check[i] == 0) continue;
				fruitSorts++;				
			}

			if (fruitSorts <= 2) answer = Math.max(answer, r-l);
			else check[fruits[l++]]--;

		}

		System.out.println(answer);
	}
}