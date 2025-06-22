import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		public int x, y;

		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int n;
	static int m;
	static int[][] board;
	final static int TETRO_SIZE = 4;

	static List<Integer> temp = new ArrayList<>();
	static boolean[][] isVisited;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		board = new int[n][m];
		isVisited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			board[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		}

		br.close();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				temp.add(board[i][j]);
				isVisited[i][j] = true;
				dfs(new Point(i, j));
				isVisited[i][j] = false;
				temp.remove(temp.size()-1);
			}
		}

		System.out.println(max);
	}

	public static void dfs(Point now) {
		if (temp.size() == TETRO_SIZE) {
			max = Math.max(max, temp.stream().mapToInt(i -> i).sum());
			return;
		}

		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

		for (int[] dir : delta) {
			int nextX = now.x + dir[0];
			int nextY = now.y + dir[1];

			if (isValidIdx(nextX, nextY) && !isVisited[nextX][nextY]) {
				if (temp.size() == 2) { // ㅗ 
					temp.add(board[nextX][nextY]);
					isVisited[nextX][nextY] = true;
					dfs(now);
					isVisited[nextX][nextY] = false;
					temp.remove(temp.size()-1);
				} 

				temp.add(board[nextX][nextY]);
				isVisited[nextX][nextY] = true;
				dfs(new Point(nextX, nextY));
				isVisited[nextX][nextY] = false;
				temp.remove(temp.size()-1);
				
			}
		}
	}
    
	public static boolean isValidIdx(int x, int y) {
		return (0 <= x && x < n) && (0 <= y && y < m);
	}
}