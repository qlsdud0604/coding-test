import java.io.*;
import java.util.*;

public class BOJ_9470 {
	static int T; // 테스트 케이스 개수

	static int K; // 테스트 케이스 번호
	static int M; // 노드의 수
	static int P; // 간선의 수

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			K = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());

			Graph graph = new Graph(M + 1);

			for (int j = 0; j < P; j++) {
				st = new StringTokenizer(br.readLine());

				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());

				graph.addEdge(A, B);
			}

			result = 0;

			graph.bfs();

			bw.write(K + " " + graph.nodes[M].sequence + "\n");
		}
		bw.close();
	}

	static class Graph {
		/* 그래프를 구성하는 각 노드에 대한 정보를 정의 */
		class Node {
			int data;
			ArrayList<Node> children;
			ArrayList<Node> parents;

			int inDegree;
			int sequence;

			Node(int data) {
				this.data = data;
				this.children = new ArrayList<>();
				this.parents = new ArrayList<>();

				this.inDegree = 0;
				this.sequence = 0;
			}

			/* 노드의 순서를 얻는 메서드 */
			void getSequence() {
				int max = 0;

				for (Node parent : this.parents) {
					if (max < parent.sequence)
						max = parent.sequence;
				}

				int count = 0;

				for (Node parent : this.parents) {
					if (parent.sequence == max)
						count++;
				}

				if (count >= 2)
					this.sequence = max + 1;
				else
					this.sequence = max;
			}
		}

		Node[] nodes;

		Graph(int size) {
			nodes = new Node[size];

			for (int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}

		/* 그래프의 간선 추가 */
		void addEdge(int A, int B) {
			nodes[A].children.add(nodes[B]);
			nodes[B].parents.add(nodes[A]);

			nodes[B].inDegree++;
		}

		/* Strahler 순서 탐색 */
		void bfs() {
			Queue<Node> queue = new LinkedList<>();

			for (int i = 1; i <= M; i++) {
				if (nodes[i].inDegree == 0) {
					nodes[i].sequence = 1;
					queue.add(nodes[i]);
				}
			}

			while (!queue.isEmpty()) {
				Node returnNode = queue.poll();

				for (Node child : returnNode.children) {
					child.inDegree--;

					if (child.inDegree == 0) {
						child.getSequence();
						queue.add(child);
					}
				}
			}
		}
	}
}