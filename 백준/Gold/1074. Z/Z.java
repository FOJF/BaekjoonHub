import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		int answer = 0;

		while(N-- > 0) {
			
			int half = (1 << N);
			
			int q = 0;
			if (r >= half) {
				r -= half;
				q += 2;
			}
			if (c >= half) {
				c -= half;
				q += 1;
			}
			answer += q * half * half;
		}

		System.out.println(answer);
	}
}