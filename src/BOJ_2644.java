import java.io.*;
import java.util.*;

public class BOJ_2644 {
	static int N;
	static int M;

	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		bfs(start, end);
	}

	static void bfs(int start, int end) {
		boolean found = false;

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(new Node(start, 0));
		visited[start] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (node.number == end) {
				found = true;
				System.out.println(node.count);
				break;
			}

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && arr[node.number][i] == 1) {
					queue.add(new Node(i, node.count + 1));
					visited[i] = true;
				}
			}
		}

		if (found == false)
			System.out.println(-1);
	}

	static class Node {
		int number;
		int count;

		Node(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
}
