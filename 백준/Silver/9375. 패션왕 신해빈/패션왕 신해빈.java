import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());


		for (int i = 0; i < n; i++) {
				int m = Integer.parseInt(br.readLine());

				HashMap<String, Integer> types = new HashMap<>();
				int answer = 0;
				int typeIndex = 0;
				int[] countClothByType = new int[m];

				for (int j = 0; j < m; j++) {
					String cloth = br.readLine();
					String type = cloth.split(" ")[1];
					
					if (!types.containsKey(type)) {
						types.put(type, typeIndex++);
						
					}

					countClothByType[types.get(type)]++;
				}

					answer = 1;

					for(int j = 0; j < countClothByType.length; j++) {
						if (countClothByType[j] < 1) break;

						answer *= countClothByType[j]+1;
					}
				
				System.out.println(answer-1);

		}
		br.close();
	}
}