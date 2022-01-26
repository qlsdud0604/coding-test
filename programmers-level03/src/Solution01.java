import java.io.*;
import java.util.*;

public class Solution01 {
	public int solution(int n, int[][] computers) {

		Graph graph = new Graph(n);

		for (int i = 0; i < computers.length; i++) {
			for (int j = 0; j < computers[i].length; j++) {
				/* 두 대의 컴퓨터가 서로 연결되어 있는 경우 */
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

	/** 그래프에 대한 정보를 정의 */
	static class Graph {
		/* 그래프의 각 노드에 대한 정보를 정의 */
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

		/* 그래프 생성자 */
		Graph(int size) {
			nodes = new Node[size];

			for (int i = 0; i < size; i++) {
				nodes[i] = new Node(i);
			}
		}

		/* 그래프 내의 노드를 연결하는 메서드 */
		void addEdge(int index01, int index02) {
			if (!nodes[index01].adjacents.contains(nodes[index02]))
				nodes[index01].adjacents.add(nodes[index02]);

			if (!nodes[index02].adjacents.contains(nodes[index01]))
				nodes[index02].adjacents.add(nodes[index01]);
		}

		/* 그래프 내의 존재하는 네트워크를 탐색 */
		int bfs(int startNode) {

			/* 이미 방문한 노드인 경우 0 반환 */
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

			/* 그렇지 않은 경우 1 반환 */
			return 1;
		}

	}
}
