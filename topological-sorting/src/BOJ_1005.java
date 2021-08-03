import java.io.*;
import java.util.*;

public class BOJ_1005 {
	static int T; // 테스트 케이스 개수
	static int N; // 건물의 개수
	static int K; // 건설 순서 규칙의 개수

	static int W; // 목표 건물

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
				int D = Integer.parseInt(st.nextToken()); // 각 건물의 건설 시간

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

			/* 현재 노드의 부모 노드 중 가장 긴 건설 시간 탐색 */
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

		/* 그래프의 간선추가 */
		void addEdge(int X, int Y) {
			nodes[X].children.add(nodes[Y]); // 자식 추가
			nodes[Y].parents.add(nodes[X]); // 부모 추가

			nodes[Y].inDegree++;
		}

		/* BFS 탐색 */
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
