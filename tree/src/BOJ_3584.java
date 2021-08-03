import java.io.*;
import java.util.*;

public class BOJ_3584 {
	static int T;
	static int N;

	static boolean[] hasParent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		/* �׽�Ʈ ���̽���ŭ �ݺ� */
		for (int i = 0; i < T; i++) {
			N = Integer.parseInt(br.readLine());

			Tree tree = new Tree(N + 1);

			hasParent = new boolean[N + 1];

			/* �θ�, �ڽ� ���迡 �ִ� ��峢�� ���� */
			for (int j = 0; j < N - 1; j++) {
				st = new StringTokenizer(br.readLine());

				int index01 = Integer.parseInt(st.nextToken());
				int index02 = Integer.parseInt(st.nextToken());

				hasParent[index02] = true;

				tree.addEdge(index01, index02);
			}

			int root = 0;

			/* ��Ʈ ��� ã�� */
			for (int j = 1; j <= N; j++) {
				if (hasParent[j] == false)
					root = j;
			}

			st = new StringTokenizer(br.readLine());

			int input01 = Integer.parseInt(st.nextToken());
			int input02 = Integer.parseInt(st.nextToken());

			tree.dfs(root, 0, -1);

			bw.write(tree.lca(input01, input02) + "\n");
		}
		bw.close();
	}

	/* Ʈ�� Ŭ���� */
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

		int[] parent;
		int[] depth;

		Tree(int size) {
			nodes = new Node[size];
			parent = new int[size];
			depth = new int[size];

			for (int i = 0; i < size; i++)
				nodes[i] = new Node(i);
		}

		/* ���� ���� �ִ� ��� �߰� */
		void addEdge(int index01, int index02) {
			if (!nodes[index01].adjacent.contains(nodes[index02]))
				nodes[index01].adjacent.add(nodes[index02]);

			if (!nodes[index02].adjacent.contains(nodes[index01]))
				nodes[index02].adjacent.add(nodes[index01]);
		}

		/* dfs�� Ʈ���� ��ȸ�ϸ� �� ����� ���̿� �θ��� ã�� */
		void dfs(int currentNode, int depth, int parent) {
			this.parent[currentNode] = parent;
			this.depth[currentNode] = depth;

			Node node = nodes[currentNode];

			for (Node child : node.adjacent) {
				if (child.data != parent)
					dfs(child.data, depth + 1, node.data);
			}
		}

		/* �� ����� ���� ����� ���� ���� ã�� */
		int lca(int input01, int input02) {
			int depth01 = this.depth[input01];
			int depth02 = this.depth[input02];

			while (depth01 > depth02) {
				input01 = this.parent[input01];
				depth01--;
			}

			while (depth02 > depth01) {
				input02 = this.parent[input02];
				depth02--;
			}

			while (input01 != input02) {
				input01 = this.parent[input01];
				input02 = this.parent[input02];
			}

			return input01;
		}
	}

}
