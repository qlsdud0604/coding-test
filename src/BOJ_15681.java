import java.io.*;
import java.util.*;

public class BOJ_15681 {
	static int N;
	static int R;
	static int Q;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		Tree tree = new Tree(N + 1);
		arr = new int[N + 1];

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int input01 = Integer.parseInt(st.nextToken());
			int input02 = Integer.parseInt(st.nextToken());

			tree.addEdge(input01, input02);
		}

		tree.dfs(R, -1);

		for (int i = 0; i < Q; i++) {
			int U = Integer.parseInt(br.readLine());

			bw.write(arr[U] + "\n");
		}
		bw.close();
	}

	/* 트리 클래스 */
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

		Tree(int size) {
			nodes = new Node[size];

			for (int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}

		/* 부모, 자식 관계에 있는 노드들 추가 */
		void addEdge(int input01, int input02) {
			if (!nodes[input01].adjacent.contains(nodes[input02]))
				nodes[input01].adjacent.add(nodes[input02]);

			if (!nodes[input02].adjacent.contains(nodes[input01]))
				nodes[input02].adjacent.add(nodes[input01]);
		}

		/* 서브 트리의 정점 개수 탐색 */
		int dfs(int currentNode, int parent) {
			arr[currentNode] = 1;

			Node node = nodes[currentNode];

			for (Node child : node.adjacent) {
				if (child.data != parent) {
					arr[currentNode] += dfs(child.data, node.data);

				}
			}

			return arr[currentNode];
		}
	}

}
