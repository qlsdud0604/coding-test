import java.io.*;
import java.util.*;

class Solution11 {
	static Node[] nodes;

	public int solution(int n, int[][] edge) {

		nodes = new Node[n];

		/** 그래프 내 노드 추가 */
		for (int i = 0; i < n; i++) {
			nodes[i] = new Node(i);
		}

		/** 각 노드들 사이에 간선 추가 */
		for (int i = 0; i < edge.length; i++) {
			int index01 = edge[i][0] - 1;
			int index02 = edge[i][1] - 1;

			if (!nodes[index01].adjacents.contains(nodes[index02]))
				nodes[index01].adjacents.add(nodes[index02]);

			if (!nodes[index02].adjacents.contains(nodes[index01]))
				nodes[index02].adjacents.add(nodes[index01]);

		}

		bfs(0);

		/** 최대 간선의 길이 계산 */
		int max = 0;

		for (Node node : nodes)
			max = Math.max(max, node.depth);

		/** 최대 간선인 노드의 개수 계산 */
		int answer = 0;

		for (Node node : nodes)
			if (max == node.depth)
				answer++;

		return answer;
	}

	/** 1번 노드부터 너비 우선 탐색 */
	static void bfs(int start) {
		Queue<Node> queue = new LinkedList<>();

		nodes[start].visited = true;

		queue.add(nodes[start]);

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (Node next : node.adjacents) {
				if (next.visited == false) {
					next.visited = true;

					next.depth = node.depth + 1;

					queue.add(next);
				}
			}
		}
	}

	/** 각 노드들의 정보를 정의한 클래스 */
	static class Node {
		int data;
		List<Node> adjacents;
		boolean visited;
		int depth;

		Node(int data) {
			this.data = data;
			this.adjacents = new ArrayList<>();
			this.visited = false;
			this.depth = 0;
		}
	}
}