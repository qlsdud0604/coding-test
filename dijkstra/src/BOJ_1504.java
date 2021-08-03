import java.io.*;
import java.util.*;

public class BOJ_1504 {
	static int N; // 정점의 개수
	static int E; // 간선의 개수

	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;

	static int v01;
	static int v02;

	static int INF = 200000001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}

		st = new StringTokenizer(br.readLine());

		v01 = Integer.parseInt(st.nextToken());
		v02 = Integer.parseInt(st.nextToken());

		long result01 = dijkstra(1, v01) + dijkstra(v01, v02) + dijkstra(v02, N);
		long result02 = dijkstra(1, v02) + dijkstra(v02, v01) + dijkstra(v01, N);

		if (result01 >= INF && result02 >= INF)
			bw.write(-1 + "\n");
		else
			bw.write(Math.min(result01, result02) + "\n");

		bw.close();
	}

	/* 두 노드의 최단거리 탐색 */
	static int dijkstra(int start, int end) {

		/* 초기화 */
		distance = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(distance, INF);

		/* 다익스트라 알고리즘 */
		PriorityQueue<Node> queue = new PriorityQueue<>();
		distance[start] = 0;
		queue.add(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (visited[current.data] == false)
				visited[current.data] = true;
			else
				continue;

			for (int i = 0; i < list[current.data].size(); i++) {
				Node next = list[current.data].get(i);

				if (distance[current.data] + next.weight < distance[next.data]) {
					distance[next.data] = distance[current.data] + next.weight;
					queue.add(new Node(next.data, distance[next.data]));
				}
			}
		}

		return distance[end];
	}

	static class Node implements Comparable<Node> {
		int data;
		int weight;

		Node(int data, int weight) {
			this.data = data;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
}