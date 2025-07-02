import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;

		public Point (int x, int y) {
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
        int answer = getFriendCnt(startP);
		System.out.println(answer == 0 ? "TT" : answer);

	}

	public static int getFriendCnt(Point startP) {
		int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};
		
		Queue<Point> bfsQ = new LinkedList<>();

		bfsQ.add(startP);
		isVisited[startP.x][startP.y] = true;

		int friendCnt = 0;

		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();
			int x = cur.x;
			int y = cur.y;

			if (board[x][y] == 'P') friendCnt++;

			for(int[] dir : delta) {
				int nx = x + dir[0];
				int ny = y + dir[1];
				if ((0 <= nx && nx < board.length) && (0 <= ny && ny < board[0].length) 
					&& !isVisited[nx][ny] && board[nx][ny] != 'X') {
					bfsQ.add(new Point(nx, ny));
					isVisited[nx][ny] = true;
				}
			}

		}

		return friendCnt;
	}
}