import java.io.*;
import java.util.*;

public class BOJ_7569 {
	static int M;
	static int N;
	static int H;

	static int[][][] arr;

	static Queue<Node> queue = new LinkedList<Node>();

	static int[] dx = { 1, -1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static int[] dz = { 0, 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		arr = new int[H][N][M];

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine());

				for (int k = 0; k < M; k++) {
					arr[i][j][k] = Integer.parseInt(st.nextToken());

					if (arr[i][j][k] == 1)
						queue.add(new Node(i, j, k));
				}
			}
		}

		bw.write(bfs() + "\n");
		bw.close();
	}

	/* 그래프 탐색 */
	static int bfs() {
		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 6; i++) {
				int x = node.x + dx[i];
				int y = node.y + dy[i];
				int z = node.z + dz[i];

				if (check(x, y, z) == true) {
					queue.add(new Node(x, y, z));
					arr[x][y][z] = arr[node.x][node.y][node.z] + 1;
				}
			}
		}

		int result = Integer.MIN_VALUE;

		for (int i = 0; i < H; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (arr[i][j][k] == 0)
						return -1;

					result = Math.max(result, arr[i][j][k]);
				}
			}
		}

		if (result == 1)
			return 0;
		else
			return (result - 1);
	}

	/* 진입 가능 여부 확인 */
	static boolean check(int x, int y, int z) {
		if (x < 0 || H <= x || y < 0 || N <= y || z < 0 || M <= z)
			return false;

		if (arr[x][y][z] == 0)
			return true;
		else
			return false;
	}

	/* 각 노드의 대한 정보 */
	static class Node {
		int x;
		int y;
		int z;

		Node(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

}
