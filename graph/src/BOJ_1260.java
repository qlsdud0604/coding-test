import java.io.*;
import java.util.*;

class Graph {
	/** 노드의 정보 */
	class Node {
		int data;
		LinkedList<Node> adjacentNode;
		boolean marked;

		Node(int data) {
			this.data = data;
			adjacentNode = new LinkedList<Node>();
			this.marked = false;
		}
	}

	Node[] nodes;

	/** 그래프 생성 */
	Graph(int size) {
		nodes = new Node[size];

		for (int i = 0; i < size; i++)
			nodes[i] = new Node(i);
	}

	/** 간선 추가 */
	void addEdge(int index01, int index02) {
		if (!nodes[index01].adjacentNode.contains(nodes[index02]))
			nodes[index01].adjacentNode.add(nodes[index02]);

		if (!nodes[index02].adjacentNode.contains(nodes[index01]))
			nodes[index02].adjacentNode.add(nodes[index01]);
	}

	/** dfs 탐색 */
	void dfs(int startNode) {
		Node root = nodes[startNode];
		dfs(root);
	}

	void dfs(Node startNode) {
		if (startNode == null)
			return;

		startNode.marked = true;

		System.out.print((startNode.data + 1) + " ");

		Collections.sort(startNode.adjacentNode, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.data > o2.data)
					return 1;
				else
					return -1;
			}
		});

		for (Node node : startNode.adjacentNode) {
			if (node.marked == false)
				dfs(node);
		}
	}

	void bfs(int startNode) {
		Node root = nodes[startNode];

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(root);
		root.marked = true;

		while (!queue.isEmpty()) {
			Node returnNode = queue.poll();

			Collections.sort(returnNode.adjacentNode, new Comparator<Node>() {

				@Override
				public int compare(Node o1, Node o2) {
					if (o1.data > o2.data)
						return 1;
					else
						return -1;

				}
			});

			for (Node node : returnNode.adjacentNode) {
				if (node.marked == false) {
					node.marked = true;
					queue.add(node);
				}
			}
			System.out.print((returnNode.data + 1) + " ");
		}
	}
}

public class BOJ_1260 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int startNode = Integer.parseInt(st.nextToken());

		Graph dfsGraph = new Graph(N);
		Graph bfsGraph = new Graph(N);

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int index01 = Integer.parseInt(st.nextToken());
			int index02 = Integer.parseInt(st.nextToken());

			dfsGraph.addEdge(index01 - 1, index02 - 1);
			bfsGraph.addEdge(index01 - 1, index02 - 1);
		}

		dfsGraph.dfs(startNode - 1);
		System.out.println();
		bfsGraph.bfs(startNode - 1);
	}
}