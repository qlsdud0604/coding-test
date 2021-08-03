import java.io.*;
import java.util.*;

public class BOJ_18404 {
	static int N;
	static int M;

	static int[][] arr;
	static boolean[][] visited;

	static int[] row = { -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] col = { -1, 1, -2, 2, -2, 2, -1, 1 };

	static ArrayList<Node> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1][N + 1];

		st = new StringTokenizer(br.readLine());

		int startX = Integer.parseInt(st.nextToken());
		int startY = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			list.add(new Node(x, y, 0));
		}

		bfs(startX, startY);

		for (Node node : list) {
			bw.write(arr[node.x][node.y] + " ");
		}

		bw.close();
	}

	/* 체스판 탐색 */
	static void bfs(int startX, int startY) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(startX, startY, 0));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			visited[startX][startY] = true;
			arr[node.x][node.y] = node.count;

			for (int i = 0; i < 8; i++) {
				int nextX = node.x + row[i];
				int nextY = node.y + col[i];

				if (check(nextX, nextY)) {
					queue.add(new Node(nextX, nextY, node.count + 1));
					visited[nextX][nextY] = true;
				}
			}
		}
	}

	/* 말판 진입 가능 여부 확인 */
	static boolean check(int x, int y) {

		if (x < 0 || N < x || y < 0 || N < y)
			return false;

		if (visited[x][y] == true)
			return false;

		return true;
	}

	/* 말판 위치에 대한 클래스 */
	static class Node {
		int x;
		int y;
		int count;

		Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}