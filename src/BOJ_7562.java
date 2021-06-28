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

public class BOJ_7562 {
	static int N;
	static int l;

	static int[][] arr;
	static boolean[][] visited;

	static int[] row = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] col = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			l = Integer.parseInt(br.readLine());

			arr = new int[l][l];
			visited = new boolean[l][l];

			/* ���� ��ġ �Է� */
			st = new StringTokenizer(br.readLine());
			Node currentNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			/* ��ǥ ��ġ �Է� */
			st = new StringTokenizer(br.readLine());
			Node targetNode = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

			bfs(currentNode.x, currentNode.y);

			bw.write(arr[targetNode.x][targetNode.y] + "\n");
		}
		bw.close();
	}

	/* ü���� Ž�� */
	static void bfs(int x, int y) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(x, y));

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x][node.y] = true;

			for (int i = 0; i < 8; i++) {
				int nodeX = node.x + row[i];
				int nodeY = node.y + col[i];

				if (!check(nodeX, nodeY))
					continue;

				queue.add(new Node(nodeX, nodeY));
				arr[nodeX][nodeY] = arr[node.x][node.y] + 1;

				visited[nodeX][nodeY] = true;
			}
		}
	}

	/* �湮 ���� ���� Ȯ�� */
	static boolean check(int x, int y) {

		if (x < 0 || l <= x || y < 0 || l <= y)
			return false;

		if (visited[x][y] == true)
			return false;

		return true;
	}
}