import java.io.*;
import java.util.*;

class Graph {
	class Node {
		int data;
		ArrayList<Node> adjacent;
		boolean marked;

		public Node(int data) {
			this.data = data;
			this.adjacent = new ArrayList<Node>();
			this.marked = false;
		}
	}

	Node[] nodes;
	int[] result;

	public Graph(int size) {
		nodes = new Node[size];
		result = new int[size];

		for (int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}

	void addEdge(int index01, int index02) {
		if (!nodes[index01].adjacent.contains(nodes[index02]))
			nodes[index01].adjacent.add(nodes[index02]);

		if (!nodes[index02].adjacent.contains(nodes[index01]))
			nodes[index02].adjacent.add(nodes[index01]);
	}

	void dfs(int startIndex) {
		Node root = nodes[startIndex];

		root.marked = true;

		Stack<Node> stack = new Stack<Node>();

		stack.add(root);

		while (!stack.isEmpty()) {
			Node returnNode = stack.pop();

			for (Node node : returnNode.adjacent) {
				if (!node.marked) {
					node.marked = true;
					stack.add(node);

					result[node.data] = returnNode.data;
				}
			}
		}
	}
}

public class BOJ_11725 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		Graph graph = new Graph(N);

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int index01 = Integer.parseInt(st.nextToken());
			int index02 = Integer.parseInt(st.nextToken());

			graph.addEdge(index01 - 1, index02 - 1);
		}

		graph.dfs(0);

		int[] result = graph.result.clone();

		for (int i = 1; i < result.length; i++)
			bw.write((result[i] + 1) + "\n");

		bw.close();
	}
}
