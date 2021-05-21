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

		Stack<Node> stack = new Stack<Node>();

		stack.add(root);
		root.visited = true;

		while (!stack.isEmpty()) {
			Node returnNode = stack.pop();

			for (Node node : returnNode.adjacent) {
				if (node.visited == false) {
					node.visited = true;
					stack.add(node);
				}
			}
		}
		return 1;
	}
}

public class BOJ_11724 {
	static Graph graph;
	static int N;
	static int M;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new Graph(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.addEdge(x - 1, y - 1);
		}

		for (int i = 0; i < N; i++) {
			if (graph.nodes[i].visited == false)
				count += graph.dfs(i);
		}
		bw.write(count + "\n");
		bw.close();
	}
}
