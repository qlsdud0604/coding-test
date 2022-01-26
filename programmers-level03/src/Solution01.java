import java.io.*;
import java.util.*;

public class Solution01 {
	public int solution(int n, int[][] computers) {

		Graph graph = new Graph(n);

		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				/* �� ���� ��ǻ�Ͱ� ���� ����Ǿ� �ִ� ��� */
				if (computers[i][j] == 1 && i != j) {
					int index01 = i;
					int index02 = j;

					graph.addEdge(index01, index02);
				}

			}
		}

		int answer = 0;

		for (int i = 0; i < n; i++) {
			answer += graph.bfs(i);
		}

		return answer;
	}

	/** �׷����� ���� ������ ���� */
	static class Graph {
		/* �׷����� �� ��忡 ���� ������ ���� */
		class Node {
			int data;
			ArrayList<Node> adjacents;
			boolean visited;

			Node(int data) {
				this.data = data;
				this.adjacents = new ArrayList<>();
				this.visited = false;
			}
		}

		Node[] nodes;

		/* �׷��� ������ */
		Graph(int size) {
			nodes = new Node[size];

			for (int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}

		/* �׷��� ���� ��带 �����ϴ� �޼��� */
		void addEdge(int index01, int index02) {
			if (!nodes[index01].adjacents.contains(nodes[index02]))
				nodes[index01].adjacents.add(nodes[index02]);

			if (!nodes[index02].adjacents.contains(nodes[index01]))
				nodes[index02].adjacents.add(nodes[index01]);
		}

		/* �׷��� ���� �����ϴ� ��Ʈ��ũ�� Ž�� */
		int bfs(int startNode) {

			/* �̹� �湮�� ����� ��� 0 ��ȯ */
			if (nodes[startNode].visited == true)
				return 0;

			Queue<Node> queue = new LinkedList<>();

			nodes[startNode].visited = true;

			queue.add(nodes[startNode]);

			while (!queue.isEmpty()) {
				Node node = queue.poll();

				for (Node next : node.adjacents) {
					if (next.visited == false) {
						next.visited = true;
						queue.add(next);
					}
				}
			}

			/* �׷��� ���� ��� 1 ��ȯ */
			return 1;
		}

	}
}
