import java.io.*;
import java.util.*;

public class BOJ_1753 {
	static int V; // 정점의 개수
	static int E; // 간선의 개수
	static int K; // 시작 정점의 번호

	static ArrayList<Node>[] list;
	static int[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		list = new ArrayList[V + 1];
		distance = new int[V + 1];
		visited = new boolean[V + 1];

		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 1; i < V + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			list[u].add(new Node(v, w));
		}
		dijkstra(K);

		for (int i = 1; i < V + 1; i++) {
			if (distance[i] == Integer.MAX_VALUE)
				bw.write("INF" + "\n");
			else
				bw.write(distance[i] + "\n");
		}
		bw.close();
	}

	static void dijkstra(int start) {
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
