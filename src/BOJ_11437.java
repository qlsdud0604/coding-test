import java.io.*;
import java.util.*;

public class BOJ_11437 {
	static int N;
	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		Tree tree = new Tree(N + 1);

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int input01 = Integer.parseInt(st.nextToken());
			int input02 = Integer.parseInt(st.nextToken());

			tree.addEdge(input01, input02);
		}

		tree.dfs(1, 0, -1);

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int input01 = Integer.parseInt(st.nextToken());
			int input02 = Integer.parseInt(st.nextToken());

			bw.write(tree.lca(input01, input02) + "\n");
		}
		bw.close();
	}

	static class Tree {
		class Node {
			int data;
			ArrayList<Node> adjacent;

			Node(int data) {
				this.data = data;
				this.adjacent = new ArrayList<>();
			}
		}

		Node[] nodes;
		int[] parent;
		int[] depth;

		Tree(int size) {
			nodes = new Node[size];
			parent = new int[size];
			depth = new int[size];

			for (int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}

		/* 부모, 자식 관계에 있는 노드끼리 연결 */
		void addEdge(int input01, int input02) {
			if (!nodes[input01].adjacent.contains(nodes[input02]))
				nodes[input01].adjacent.add(nodes[input02]);

			if (!nodes[input02].adjacent.contains(nodes[input01]))
				nodes[input02].adjacent.add(nodes[input01]);
		}

		/* dfs 순회를 통해 각 노드들의 부모, 깊이 정보 탐색 */
		void dfs(int current, int depth, int parent) {
			this.parent[current] = parent;
			this.depth[current] = depth;

			Node node = nodes[current];

			for (Node child : node.adjacent) {
				if (child.data != parent)
					dfs(child.data, depth + 1, node.data);
			}
		}

		/* 두 노드의 가장 가까운 공통 조상 탐색 */
		int lca(int input01, int input02) {
			int depth01 = this.depth[input01];
			int depth02 = this.depth[input02];

			while (depth01 < depth02) {
				input02 = this.parent[input02];
				depth02--;
			}

			while (depth02 < depth01) {
				input01 = this.parent[input01];
				depth01--;
			}

			while (input01 != input02) {
				input01 = this.parent[input01];
				input02 = this.parent[input02];
			}

			return input01;
		}
	}

}
