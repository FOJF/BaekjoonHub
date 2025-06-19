import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < t; i++) {
			TreeMap<Integer, Integer> treeMap = new TreeMap<>();
			int k = Integer.parseInt(br.readLine());
			for (int j = 0; j < k; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				if (st.nextToken().charAt(0) == 'I') {
					int num = Integer.parseInt(st.nextToken());
					treeMap.put(num, treeMap.getOrDefault(num,0)+1);
				} else if (st.nextToken().charAt(0) == '1'){
					if (treeMap.isEmpty()) continue;
					int key = treeMap.lastKey();
					
					treeMap.put(key, treeMap.get(key)-1);
					if (treeMap.get(key) == 0) treeMap.pollLastEntry();
				} else {
					if (treeMap.isEmpty()) continue;
					int key = treeMap.firstKey();
					
					treeMap.put(key, treeMap.get(key)-1);
					if (treeMap.get(key) == 0) treeMap.pollFirstEntry();
				}
			}
			if (treeMap.isEmpty()) sb.append("EMPTY\n");
			else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append("\n");
		}

		System.out.println(sb);
	}
}