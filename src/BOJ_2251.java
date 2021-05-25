import java.io.*;
import java.util.*;

class Node {
	int a;
	int b;
	int c;

	Node(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class BOJ_2251 {
	static int maxA;
	static int maxB;
	static int maxC;

	static boolean[][][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		maxA = Integer.parseInt(st.nextToken());
		maxB = Integer.parseInt(st.nextToken());
		maxC = Integer.parseInt(st.nextToken());

		visited = new boolean[maxA + 1][maxB + 1][maxC + 1];

		Node root = new Node(0, 0, maxC);

		bfs(root);

		Collections.sort(list);

		for (int i : list)
			bw.write(i + " ");

		bw.close();
	}

	static void bfs(Node root) {
		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			if (visited[node.a][node.b][node.c])
				continue;

			if (node.a == 0)
				list.add(node.c);

			visited[node.a][node.b][node.c] = true;

			/** b -> a */
			if (node.a + node.b <= maxA)
				queue.add(new Node(node.a + node.b, 0, node.c));
			else
				queue.add(new Node(maxA, node.b + node.a - maxA, node.c));

			/** c -> a */
			if (node.a + node.c <= maxA)
				queue.add(new Node(node.a + node.c, node.b, 0));
			else
				queue.add(new Node(maxA, node.b, node.c + node.a - maxA));

			/** a -> b */
			if (node.b + node.a <= maxB)
				queue.add(new Node(0, node.b + node.a, node.c));
			else
				queue.add(new Node(node.a + node.b - maxB, maxB, node.c));

			/** c -> b */
			if (node.b + node.c <= maxB)
				queue.add(new Node(node.a, node.b + node.c, 0));
			else
				queue.add(new Node(node.a, maxB, node.c + node.b - maxB));

			/** a -> c */
			if (node.c + node.a <= maxC)
				queue.add(new Node(0, node.b, node.c + node.a));
			else
				queue.add(new Node(node.a + node.c - maxC, node.b, maxC));

			/** b -> c */
			if (node.c + node.b <= maxC)
				queue.add(new Node(node.a, 0, node.c + node.b));
			else
				queue.add(new Node(node.a, node.b + node.c - maxC, maxC));

		}
	}

}
