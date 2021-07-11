import java.io.*;
import java.util.*;

public class BOJ_14267 {
	static int N;
	static int M;

	static int[] parents;
	static int[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Tree tree = new Tree(N + 1);
		parents = new int[N + 1];
		result = new int[N + 1];

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= N; i++) {
			parents[i] = Integer.parseInt(st.nextToken());

			if (parents[i] != -1) {
				int input01 = i;
				int input02 = parents[i];

				tree.addEdge(input01, input02);
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int nodeNum = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			result[nodeNum] += weight;
		}

		tree.dfs(1, parents[1]);

		for (int i = 1; i <= N; i++)
			bw.write(result[i] + " ");

		bw.close();
	}

	static class Tree {
		class Node {
			int data;
			ArrayList<Node> adjacent;

			Node(int data) {
				this.data = data;
				this.adjacent = new ArrayList<Node>();
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

		/* 각 노드들의 칭찬 점수 탐색 */
		void dfs(int startNode, int parent) {

			Node node = nodes[startNode];

			for (Node child : node.adjacent) {
				if (child.data != parent) {
					result[child.data] += result[node.data];

					dfs(child.data, node.data);
				}
			}
		}
	}

}
