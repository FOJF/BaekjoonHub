import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		String s = br.readLine();
		br.close();

		System.out.println(getCnt(s,n));
	}

	public static int getCnt(String s, int n) {
		StringBuilder sb = new StringBuilder();
		int total = 0;

		for (int i = 0; i < n; i++) {
			sb.append("IO");
		}
		sb.append("I");

		String original = sb.toString();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != 'I') continue;

			int cnt = 0;
			
			if (!s.startsWith(original, i)) continue;

			for (int j = i + original.length(); j+2 <= s.length(); j += 2) {
				if (s.charAt(j) == 'O' && s.charAt(j+1) == 'I') {
                     cnt++;
                     i += 2;
                }
				else {break;}
			}
	i += original.length()-1;
			total += (cnt + 1);
		}

		return total;
	}
}