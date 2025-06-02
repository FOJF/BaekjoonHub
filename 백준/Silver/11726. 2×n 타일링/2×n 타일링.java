import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		br.close();

		int[] answers = new int[]{1,2};

		for (int i = 2; i < n; i++) {
			int temp = answers[0];
			answers[0] = answers[1];
			answers[1] = (temp+answers[0])%10007;
		}

		if (n == 1) System.out.println(answers[0]);
		else System.out.println(answers[1]);
	}
}