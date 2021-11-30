import java.io.*;
import java.util.*;

public class Solution04 {

	static ArrayList<Node>[] graph;
	static boolean[] visited;

	static int[][] distance;

	public int solution(int n, int s, int a, int b, int[][] fares) {

		graph = new ArrayList[n + 1];
		distance = new int[n + 1][n + 1];

		for (int i = 1; i < n + 1; i++)
			graph[i] = new ArrayList<>();

		/** 그래프 생성 */
		for (int i = 0; i < fares.length; i++) {
			int x = fares[i][0];
			int y = fares[i][1];
			int cost = fares[i][2];

			graph[x].add(new Node(y, cost));
			graph[y].add(new Node(x, cost));
		}

		/** 각 지점의 최단거리 계산 */
		for (int i = 1; i < n + 1; i++) {
			visited = new boolean[n + 1];
			dijkstra(i);
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 1; i < n + 1; i++) {
			int current = distance[s][i];

			int next01 = distance[i][a];
			int next02 = distance[i][b];

			answer = Math.min(answer, current + next01 + next02);
		}
		System.out.println(answer);

		return answer;
	}

	/** 다익스트라 알고리즘 */
	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		queue.add(new Node(start, 0));

		Arrays.fill(distance[start], Integer.MAX_VALUE);

		distance[start][start] = 0;

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (visited[current.number])
				continue;
			else
				visited[current.number] = true;

			for (int i = 0; i < graph[current.number].size(); i++) {
				Node next = graph[current.number].get(i);

				if (distance[start][current.number] + next.cost < distance[start][next.number]) {
					distance[start][next.number] = distance[start][current.number] + next.cost;

					queue.add(new Node(next.number, distance[start][next.number]));
				}
			}
		}
	}

	/** 노드에 대한 정보를 정의 */
	static class Node implements Comparable<Node> {
		int number;
		int cost;

		Node(int number, int cost) {
			this.number = number;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
}