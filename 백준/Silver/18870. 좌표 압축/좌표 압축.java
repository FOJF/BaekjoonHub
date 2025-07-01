import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
        
        int[] original = new int[n];
        
        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        int[] set = Arrays.stream(original).distinct().sorted().toArray();
		
		StringBuilder sb = new StringBuilder();

		for(int num : original) {
			sb.append(Arrays.binarySearch(set, num)).append(" ");
		}
		
		System.out.println(sb);
	}
}