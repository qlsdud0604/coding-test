import java.io.*;
import java.util.*;

class Graph {
	class Node {
		int data;
		ArrayList<Node> adjacent;
		boolean visited;

		Node(int data) {
			this.data = data;
			this.adjacent = new ArrayList<Node>();
			this.visited = false;
		}
	}

	Node[] nodes;

	Graph(int size) {
		nodes = new Node[size];

		for (int i = 0; i < size; i++)
			nodes[i] = new Node(i);
	}

	void addEdge(int index01, int index02) {
		if (!nodes[index01].adjacent.contains(nodes[index02]))
			nodes[index01].adjacent.add(nodes[index02]);

		if (!nodes[index02].adjacent.contains(nodes[index01]))
			nodes[index02].adjacent.add(nodes[index01]);
	}

	int dfs(int index) {
		Node root = nodes[index];
		root.visited = true;

		int value = 0;

		Stack<Node> stack = new Stack<Node>();

		stack.add(root);

		while (!stack.isEmpty()) {
			Node returnNode = stack.pop();

			for (Node node : returnNode.adjacent) {
				if (node.visited == false) {
					stack.add(node);
					node.visited = true;

					value += 1;
				}
			}
		}

		return value;
	}
}

public class BOJ_2606 {
	static int N; // 노드의 수
	static int M; // 엣지의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		Graph graph = new Graph(N);

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.addEdge(x - 1, y - 1);
		}

		bw.write(graph.dfs(0) + "\n");
		bw.close();
	}
}