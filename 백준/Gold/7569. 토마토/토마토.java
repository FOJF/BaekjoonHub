import java.io.*;
import java.util.*;

public class Main {
	static class Point {
		int x;
		int y;
		int z;

		public Point(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int[][][] trays;
	static Queue<Point> bfsQ = new LinkedList<>();

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

		trays = new int[input[2]][input[1]][input[0]];

		for (int i = 0; i < trays.length; i++) {
			for (int j = 0; j < trays[i].length; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
				for (int k = 0; k < trays[i][j].length; k++) {
					trays[i][j][k] = Integer.parseInt(st.nextToken());
                    if (trays[i][j][k] == 1) bfsQ.add(new Point(i,j,k));
				}
			}
		}

		br.close();

		// System.out.println(Arrays.deepToString(trays));
        bfs();

		// bfs(new Point(0,1,3));

		// System.out.println(Arrays.deepToString(distances));

		int max = 0;
		for (int i = 0; i < trays.length; i++) {
			for (int j = 0; j < trays[i].length; j++) {
				for (int k = 0; k < trays[i][j].length; k++) {
                    if (trays[i][j][k] == 0) {System.out.println("-1");return;}
                    max = Math.max(max, trays[i][j][k]);
                }
			}
		}
		System.out.println(max-1);
	}

	public static void bfs() {
		int[][] delta = {{1,0,0},{-1,0,0},{0,1,0},{0,-1,0},{0,0,1},{0,0,-1}};

		while(!bfsQ.isEmpty()) {
			Point cur = bfsQ.poll();

			for (int[] dir : delta) {
				int newX = cur.x + dir[0];
				int newY = cur.y + dir[1];
				int newZ = cur.z + dir[2];


				// System.out.println(newX + " " + newY + " " + newZ);

				if (isValidPoint(newX, newY, newZ) && trays[newX][newY][newZ] == 0) {
					bfsQ.offer(new Point(newX, newY, newZ));
					trays[newX][newY][newZ] = trays[cur.x][cur.y][cur.z] + 1;
				}
			}
		}

	}

	public static boolean isValidPoint(int x, int y, int z) {
		return hasIdx(x, y, z) && trays[x][y][z] == 0;
	}

	public static boolean hasIdx(int x, int y, int z) {
		return (0 <= x && x < trays.length) && (0 <= y && y < trays[0].length) && (0 <= z && z < trays[0][0].length);
	}
}