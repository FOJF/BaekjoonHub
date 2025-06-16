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

	public static int getCnt(String s, int n, int i) {
		if (i == 0 || s.length()/2 < i) return 0;
		String ioi = "IO".repeat(i)+"I";

		String[] sArr = s.split(ioi);

		int cnt = 0;
		for (String ss : sArr) {
			// System.out.println(i);
			cnt += getCnt(ss, n, i-1);
		}
		return (sArr.length-1) * (i-n+1)+cnt;
	}

	public static int getCnt(String s, int n) {
		StringBuilder sb = new StringBuilder();
		int total = 0;

		for (int i = 0; i < n; i++) {
			sb.append("IO");
		}
		sb.append("I");

		String original = sb.toString();

		int i = s.indexOf(sb.toString());

		while (i != -1) {
			s = s.substring(i);	
			int cnt = 1;
			sb.append("OI");
			while (s.startsWith(sb.toString())) {
				cnt++;
				sb.append("OI");
			}
			
 			s = s.substring(sb.length()-2);
 
			sb.setLength(0);
			sb.append(original);
			
			i = s.indexOf(sb.toString());

			// System.out.println(cnt);
			// System.out.println(s);


			total += cnt;
		}

		return total;
/*
1
13
IOIOIOIIIIIOI
*/
	}
}