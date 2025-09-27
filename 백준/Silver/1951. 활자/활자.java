import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = br.readLine();

		br.close();

		char[] ch = input.toCharArray();
		long n = Long.parseLong(input);

		long answer = 0;

		long a = 1;
		for(int i = 0; i < ch.length-1; i++) {
			a *= 10;
			answer += (a-(a/10))*(i+1);
		}

		if (ch.length == 1) answer = n;
		else answer += (n+1 - a) * ch.length;

		System.out.println(answer%1234567);
	}
}

// 2000000000