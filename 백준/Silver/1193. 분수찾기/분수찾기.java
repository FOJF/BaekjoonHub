import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int X = Integer.parseInt(br.readLine());

		int t_floors = 0;
		int sum = 0;

		while(sum < X) {
			sum += ++t_floors;
		}

		int offset = sum - X;

		StringBuilder sb = new StringBuilder();

		if (t_floors % 2 == 0)
			sb.append(t_floors-offset).append("/").append(1+offset);
		else
			sb.append(1+offset).append("/").append(t_floors-offset);

		System.out.println(sb);
	}
}