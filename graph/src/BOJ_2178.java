import java.io.*;
import java.util.*;

class Node {
	int x;
	int y;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ_2178 {
	static int N;
	static int M;
	static int[][] maze;
	static boolean[][] visited;

	static int[] row = { -1, 0, 1, 0 };
	static int[] col = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		maze = new int[N][M];
		visited = new boolean[N][M];

		/* 미로 데이터 입력 */
		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("");

			for (int j = 0; j < M; j++) {
				maze[i][j] = Integer.parseInt(input[j]);
			}
		}

		bfs(0, 0);

		bw.write(maze[N - 1][M - 1] + "\n");
		bw.close();
	}

	/* 미로 탐색 */
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(new Node(x, y));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x][node.y] = true;

			for (int i = 0; i < 4; i++) {
				int nodeX = node.x + row[i];
				int nodeY = node.y + col[i];

				if (!check(nodeX, nodeY))
					continue;

				queue.add(new Node(nodeX, nodeY));

				maze[nodeX][nodeY] = maze[node.x][node.y] + 1;

				visited[nodeX][nodeY] = true;
			}
		}

	}

	/* 진입 가능 여부 판단 */
	static boolean check(int x, int y) {
		if (x < 0 || N <= x || y < 0 || M <= y)
			return false;

		if (maze[x][y] == 0 || visited[x][y] == true)
			return false;

		return true;
	}
}
