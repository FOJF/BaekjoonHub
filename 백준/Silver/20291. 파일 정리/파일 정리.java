import java.io.*;
import java.util.*;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		Map<String, Integer> treeMap = new TreeMap<>();

		for (int i = 0; i < n; i++) {
			String s = br.readLine().split("\\.")[1];
			treeMap.put(s, treeMap.getOrDefault(s, 0)+1);
		}

		br.close();

		for (String s : treeMap.keySet()) {
			System.out.println(s + " " + treeMap.get(s));
		}
	}
}