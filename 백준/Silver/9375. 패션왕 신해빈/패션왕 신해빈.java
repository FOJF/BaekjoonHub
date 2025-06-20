import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
				int m = Integer.parseInt(br.readLine());

				HashMap<String, Integer> types = new HashMap<>();

				for (int j = 0; j < m; j++) {
					String type = br.readLine().split(" ")[1];
					
                    types.put(type, types.getOrDefault(type, 0) + 1);
				}

                int answer = 1;
                
                for (int cnt : types.values()) {
                    answer *= (cnt+1);
                }
                
				System.out.println(answer-1);
		}
		br.close();
	}
}