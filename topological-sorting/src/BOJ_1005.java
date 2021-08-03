import java.io.*;
import java.util.*;

public class BOJ_1005 {
	static int T; // �׽�Ʈ ���̽� ����
	static int N; // �ǹ��� ����
	static int K; // �Ǽ� ���� ��Ģ�� ����

	static int W; // ��ǥ �ǹ�

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			Graph graph = new Graph(N + 1);

			st = new StringTokenizer(br.readLine());

			for (int j = 1; j < N + 1; j++) {
				int D = Integer.parseInt(st.nextToken()); // �� �ǹ��� �Ǽ� �ð�

				graph.nodes[j].time = D;
			}

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());

				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());

				graph.addEdge(X, Y);
			}

			W = Integer.parseInt(br.readLine());

			graph.bfs();

			bw.write(graph.nodes[W].time + "\n");

		}
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

		/* �׷����� �����߰� */
		void addEdge(int X, int Y) {
			nodes[X].children.add(nodes[Y]); // �ڽ� �߰�
			nodes[Y].parents.add(nodes[X]); // �θ� �߰�

			nodes[Y].inDegree++;
		}

		/* BFS Ž�� */
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
