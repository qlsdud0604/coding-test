import java.io.*;
import java.util.*;

public class BOJ_1916 {
	static int N; // 도시의 개수
	static int M; // 버스의 개수

	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		list = new ArrayList[N + 1];
		distance = new int[N + 1];
		visited = new boolean[N + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 1; i < N + 1; i++) {
			list[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, cost));
		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		Dijkstra(start);

		bw.write(distance[end] + "\n");
		bw.close();
	}

	/* 각 노드까지의 최소 비용 탐색 */
	static void Dijkstra(int start) {
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

				if (distance[current.data] + next.cost < distance[next.data]) {
					distance[next.data] = distance[current.data] + next.cost;

					queue.add(new Node(next.data, distance[next.data]));
				}
			}
		}
	}

	/* 그래프의 각 노드에 대한 정보 정의 */
	static class Node implements Comparable<Node> {
		int data;
		int cost;

		Node(int data, int cost) {
			this.data = data;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
}