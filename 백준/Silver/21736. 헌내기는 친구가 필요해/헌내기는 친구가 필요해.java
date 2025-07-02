import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		private int x;
		private int y;

		public Point (int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return this.x;
		}

		public int getY() {
			return this.y;
		}

		public void setXY(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}


	static char[][] board;
	static boolean[][] isVisited;
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] input = br.readLine().split(" ");

		final int N = Integer.parseInt(input[0]);
		final int M = Integer.parseInt(input[1]);

		board = new char[N][M];
		isVisited = new boolean[N][M];

		Point startP = null;

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'I') startP = new Point(i,j);
			}
		}
		br.close();

		// System.out.println(Arrays.deepToString(board));
		System.out.println(getFriendCnt(startP));

	}

	public static String getFriendCnt(Point startP) {
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
		
		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(startP);
		isVisited[startP.getX()][startP.getY()] = true;

		int friendCnt = 0;

		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();
			int curX = cur.getX();
			int curY = cur.getY();

			if (board[curX][curY] == 'P') friendCnt++;

			for(int[] dir : delta) {
				int nextX = curX + dir[0];
				int nextY = curY + dir[1];
				if ((0 <= nextX && nextX < board.length) && (0 <= nextY && nextY < board[0].length) 
					&& !isVisited[nextX][nextY] && board[nextX][nextY] != 'X') {
					bfsQ.add(new Point(nextX, nextY));
					isVisited[nextX][nextY] = true;
				}
			}

		}

		return friendCnt == 0 ? "TT" : String.valueOf(friendCnt);
	}
}