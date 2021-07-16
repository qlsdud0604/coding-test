import java.io.*;
import java.util.*;

public class BOJ_1516 {
	static int N; // �ǹ��� ����

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		Graph graph = new Graph(N + 1);

		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());

			int time = Integer.parseInt(st.nextToken());

			graph.nodes[i].time = time;

			while (true) {
				int X = Integer.parseInt(st.nextToken());
				int Y = i;

				if (X != -1) {
					graph.addEdge(X, Y);
				} else
					break;
			}
		}

		graph.bfs();

		for (int i = 1; i < N + 1; i++)
			bw.write(graph.nodes[i].time + "\n");

		bw.close();
	}

	static class Graph {
		/* ����� ������ ���� */
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

			/* ���� ����� �θ� ��� �� ���� �� �Ǽ� �ð� Ž�� */
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

		/* �׷����� ���� �߰� */
		void addEdge(int X, int Y) {
			nodes[X].children.add(nodes[Y]);
			nodes[Y].parents.add(nodes[X]);

			nodes[Y].inDegree++;
		}

		/* �� ����� �ּ� �Ǽ� �ð� Ž�� */
		void bfs() {
			Queue<Node> queue = new LinkedList<>();

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