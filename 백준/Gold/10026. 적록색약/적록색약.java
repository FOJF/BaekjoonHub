import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x, y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static char[][] board;
	static boolean[][] isVisitedForNormal;
	static boolean[][] isVisitedForColorBlind;
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		board = new char[n][n];
		isVisitedForNormal = new boolean[n][n];
		isVisitedForColorBlind = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j = 0; j < n; j++) {
				board[i][j] = input[j];
			}
		}

		br.close();

		int[] count = new int[2]; // 0 normal, 1 colorblind
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!isVisitedForNormal[i][j]) {bfsForNormal(new Point(i,j)); count[0]++;}
				if (!isVisitedForColorBlind[i][j]) {bfsForColorBlind(new Point(i,j)); count[1]++;}
			}
		}
		System.out.println(count[0] + " " + count[1]);
	}

	public static void bfsForNormal(Point start) {
		int[][] delta = {{0,-1},{0,1},{-1,0},{1,0}};
		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(start);
		isVisitedForNormal[start.x][start.y] = true;

		while(!bfsQ.isEmpty()) {
			Point now = bfsQ.poll();

			for (int[] dir : delta) {
				int nextX = now.x + dir[0];
				int nextY = now.y + dir[1];

				if ((0 <= nextX && nextX < n) && (0 <= nextY && nextY < n) && !isVisitedForNormal[nextX][nextY] && board[nextX][nextY] == board[start.x][start.y]) {
					bfsQ.add(new Point(nextX, nextY));
					isVisitedForNormal[nextX][nextY] = true;
				}
			}
		}
	}

	public static void bfsForColorBlind(Point start) {
		int[][] delta = {{0,-1},{0,1},{-1,0},{1,0}};
		
		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(start);
		isVisitedForColorBlind[start.x][start.y] = true;

		while(!bfsQ.isEmpty()) {
			Point now = bfsQ.poll();

			for (int[] dir : delta) {
				int nextX = now.x + dir[0];
				int nextY = now.y + dir[1];

				if ((0 <= nextX && nextX < n) && (0 <= nextY && nextY < n) && !isVisitedForColorBlind[nextX][nextY] 
					&& isSameColorWithColorBlind(board[start.x][start.y], board[nextX][nextY])) {
					bfsQ.add(new Point(nextX, nextY));
					isVisitedForColorBlind[nextX][nextY] = true;
				}

			}
		}
	}

	public static boolean isSameColorWithColorBlind(char a, char b) {
		if (a == 'B') return b == 'B';

		return b != 'B';
	}
}