import java.io.*;
import java.util.*;

public class BOJ_2637 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		Graph graph = new Graph(N + 1);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int X = Integer.parseInt(st.nextToken()); // 후행 노드
			int Y = Integer.parseInt(st.nextToken()); // 선행 노드
			int K = Integer.parseInt(st.nextToken()); // 선행 노드의 필요 개수

			graph.addEdge(X, Y, K);
		}

		graph.bfs();

		for (int i = 1; i < N + 1; i++) {
			if (graph.nodes[i].inDegree == 0)
				bw.write(i + " " + graph.nodes[i].number + "\n");
		}
		bw.close();
	}

	static class Graph {
		/* 그래프의 노드 정보를 정의 */
		class Node {
			int data; // 현재 노드의 번호
			ArrayList<Edge> parents; // 현재 노드의 선행 노드
			int number; // 현재 노드가 필요한 개수
			int inDegree; // 현재 노드의 선행 노드 개수
			int outDegree; // 현재 노드의 후행 노드 개수

			Node(int data) {
				this.data = data;
				this.parents = new ArrayList<>();
				this.number = 0;
				this.inDegree = 0;
			}
		}

		/* 그래프의 간선 정보를 정의 */
		class Edge {
			int data; // 선행 노드의 번호
			int number; // 선행 노드의 필요 개수

			Edge(int data, int number) {
				this.data = data;
				this.number = number;
			}
		}

		Node[] nodes;

		Graph(int size) {
			nodes = new Node[size];

			for (int i = 0; i < size; i++)
				nodes[i] = new Node(i);
		}

		/* 그래프 간선 추가 */
		void addEdge(int X, int Y, int number) {
			nodes[X].parents.add(new Edge(Y, number));

			nodes[X].inDegree++;
			nodes[Y].outDegree++;
		}

		/* 각 노드들의 필요 개수 탐색 */
		void bfs() {
			Queue<Node> queue = new LinkedList<Node>();
			nodes[N].number = 1;
			queue.add(nodes[N]);

			while (!queue.isEmpty()) {
				Node returnNode = queue.poll();

				for (Edge parent : returnNode.parents) {
					nodes[parent.data].number += returnNode.number * parent.number;

					nodes[parent.data].outDegree--;

					if (nodes[parent.data].outDegree == 0) {
						queue.add(nodes[parent.data]);
					}
				}
			}
		}
	}
}