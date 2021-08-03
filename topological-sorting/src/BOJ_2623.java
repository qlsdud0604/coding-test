import java.io.*;
import java.util.*;

public class BOJ_2623 {
	static int N;
	static int M;

	static int count;
	static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Graph graph = new Graph(N + 1);

		for (int i = 0; i < M; i++) {
			String[] input = br.readLine().split(" ");

			for (int j = 1; j < Integer.parseInt(input[0]); j++) {
				int input01 = Integer.parseInt(input[j]);
				int input02 = Integer.parseInt(input[j + 1]);

				graph.addEdge(input01, input02);
			}
		}

		graph.bfs();

		if (count == N) {
			for (int data : result)
				bw.write(data + "\n");
		} else
			bw.write(0 + "\n");

		bw.close();
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

				count++;

				result.add(returnNode.data);

				for (Node child : returnNode.adjacent) {
					child.degree--;

					if (child.degree == 0) {
						queue.add(child);
					}
				}
			}
		}
	}
}
