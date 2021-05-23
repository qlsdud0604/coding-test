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
	int[] arr;

	Graph(int size) {
		nodes = new Node[size];
		arr = new int[size];

		for (int i = 0; i < size; i++)
			nodes[i] = new Node(i);
	}

	void addEdge(int index01, int index02) {
		if (!nodes[index01].adjacent.contains(nodes[index02]))
			nodes[index01].adjacent.add(nodes[index02]);

		if (!nodes[index02].adjacent.contains(nodes[index01]))
			nodes[index02].adjacent.add(nodes[index01]);
	}

	void dfs(int startIndex) {
		Node root = nodes[startIndex];

		root.visited = true;

		Stack<Node> stack = new Stack<Node>();

		stack.add(root);

		while (!stack.isEmpty()) {
			Node returnNode = stack.pop();

			for (Node node : returnNode.adjacent) {
				if (node.visited == false) {
					node.visited = true;

					stack.add(node);
					arr[node.data] = returnNode.data;
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

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph.addEdge(x - 1, y - 1);
		}

		graph.dfs(0);

		int[] result = graph.arr.clone();

		for (int i = 1; i < result.length; i++)
			bw.write((result[i] + 1) + "\n");

		bw.close();
	}
}
