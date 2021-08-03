import java.io.*;
import java.util.*;

public class BOJ_1240 {
	static int N, M;

	static ArrayList<Node>[] list;
	static int[] distance; // 최단 거리를 저장할 배열
	static boolean[] visited; // 노드의 방문 여부를 저장할 배열

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < N - 1; i++) {

			st = new StringTokenizer(br.readLine());

			int node01 = Integer.parseInt(st.nextToken());
			int node02 = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			list[node01].add(new Node(node02, weight));
			list[node02].add(new Node(node01, weight));
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			distance = new int[N + 1];
			Arrays.fill(distance, Integer.MAX_VALUE);

			visited = new boolean[N + 1];

			dijkstra(start, end);
			bw.write(distance[end] + "\n");
		}
		bw.close();
	}

	/* 다익스트라 알고리즘 */
	static void dijkstra(int start, int end) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		distance[start] = 0;

		queue.add(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (visited[current.number] == false)
				visited[current.number] = true;
			else
				continue;

			for (int i = 0; i < list[current.number].size(); i++) {
				Node next = list[current.number].get(i);

				if (distance[current.number] + next.weight < distance[next.number]) {
					distance[next.number] = distance[current.number] + next.weight;
					queue.add(new Node(next.number, distance[next.number]));
				}
			}
		}
	}

	/* 그래프를 구성하는 각 노드에 대한 클래스 */
	static class Node implements Comparable<Node> {
		int number;
		int weight;

		Node(int number, int weight) {
			this.number = number;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}