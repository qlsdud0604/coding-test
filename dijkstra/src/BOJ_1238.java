import java.io.*;
import java.util.*;

public class BOJ_1238 {
	static int N; // 마을의 개수
	static int M; // 도로의 개수
	static int X; // 파티가 열리는 마을

	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, c));
		}

		int max = 0;

		for (int i = 1; i < N + 1; i++) {
			int compare = dijkstra(i, X) + dijkstra(X, i);

			max = Math.max(max, compare);
		}

		bw.write(max + "\n");
		bw.close();
	}

	static int dijkstra(int start, int end) {
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

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
