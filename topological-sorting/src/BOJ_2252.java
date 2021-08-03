import java.io.*;
import java.util.*;

public class BOJ_2252 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Graph graph = new Graph(N + 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int input01 = Integer.parseInt(st.nextToken());
			int input02 = Integer.parseInt(st.nextToken());

			graph.addEdge(input01, input02);
		}

		graph.bfs();
	}

	static class Graph {
		class Node {
			int data;
			ArrayList<Node> adjacent;
			int degree;

			Node(int data) {
				this.data = data;
				this.adjacent = new ArrayList<>();
				this.degree = 0;
			}
		}

		Node[] nodes;

		Graph(int size) {
			nodes = new Node[size];

			for (int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}

		void addEdge(int input01, int input02) {
			if (!nodes[input01].adjacent.contains(nodes[input02]))
				nodes[input01].adjacent.add(nodes[input02]);

			nodes[input02].degree++;
		}

		void bfs() {
			Queue<Node> queue = new LinkedList<Node>();

			for (int i = 1; i <= N; i++) {
				if (nodes[i].degree == 0)
					queue.add(nodes[i]);
			}

			while (!queue.isEmpty()) {
				Node returnNode = queue.poll();

				System.out.print(returnNode.data + " ");

				for (Node child : returnNode.adjacent) {
					child.degree--;

					if (child.degree == 0)
						queue.add(child);
				}
			}
		}
	}

}
