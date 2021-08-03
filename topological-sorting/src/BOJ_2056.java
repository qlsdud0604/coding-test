import java.io.*;
import java.util.*;

public class BOJ_2056 {
	static int N; // 작업의 개수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		Graph graph = new Graph(N + 1);

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());

			graph.nodes[i].time = Integer.parseInt(st.nextToken());

			int K = Integer.parseInt(st.nextToken());

			for (int j = 0; j < K; j++) {
				int X = Integer.parseInt(st.nextToken());
				int Y = i;

				graph.addEdge(X, Y);
			}
		}

		graph.bfs();

		int result = 0;

		for (int i = 1; i < N + 1; i++)
			if (result < graph.nodes[i].time)
				result = graph.nodes[i].time;

		bw.write(result + "\n");
		bw.close();
	}

	static class Graph {
		/* 노드의 정보를 정의 */
		class Node {
			int data;
			ArrayList<Node> children;
			ArrayList<Node> parents;
			int inDegree;
			int time;

			Node(int data) {
				this.data = data;
				this.children = new ArrayList<>();
				this.parents = new ArrayList<>();
				this.inDegree = 0;
				this.time = 0;
			}

			int getMax() {
				int max = 0;

				for (int i = 0; i < this.parents.size(); i++) {
					if (max < this.parents.get(i).time)
						max = this.parents.get(i).time;
				}

				return max;
			}
		}

		Node[] nodes;

		Graph(int size) {
			nodes = new Node[size];

			for (int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}

		/* 간선 추가 */
		void addEdge(int X, int Y) {
			nodes[X].children.add(nodes[Y]);
			nodes[Y].parents.add(nodes[X]);

			nodes[Y].inDegree++;
		}

		/* 각 작업의 완료 시간 탐색 */
		void bfs() {
			Queue<Node> queue = new LinkedList<Node>();

			for (int i = 1; i < N + 1; i++) {
				if (nodes[i].inDegree == 0)
					queue.add(nodes[i]);
			}

			while (!queue.isEmpty()) {
				Node returnNode = queue.poll();

				for (Node child : returnNode.children) {
					child.inDegree--;

					if (child.inDegree == 0) {
						child.time += child.getMax();
						queue.add(child);
					}
				}
			}
		}
	}
}
