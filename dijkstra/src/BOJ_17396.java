import java.io.*;
import java.util.*;

public class BOJ_17396 {
	static int N; // 분기점의 수
	static int M; // 길의 수

	static ArrayList<Node>[] list;
	static int[] sight;

	static long[] distance;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		list = new ArrayList[N];
		sight = new int[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N - 1; i++) {
			sight[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int t = Integer.parseInt(st.nextToken());

			list[a].add(new Node(b, t));
			list[b].add(new Node(a, t));
		}

		dijkstra(0);

		if (distance[N - 1] == Long.MAX_VALUE)
			bw.write(-1 + "\n");
		else
			bw.write(distance[N - 1] + "\n");

		bw.close();
	}

	static void dijkstra(int start) {
		distance = new long[N];
		visited = new boolean[N];
		Arrays.fill(distance, Long.MAX_VALUE);

		PriorityQueue<Node> queue = new PriorityQueue<>();
		distance[start] = 0;
		queue.add(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			/* 방문 여부 검사 */
			if (visited[current.data] == false)
				visited[current.data] = true;
			else
				continue;

			/* 진입 여부 검사 */
			if (sight[current.data] == 1)
				continue;

			for (int i = 0; i < list[current.data].size(); i++) {
				Node next = list[current.data].get(i);

				if (distance[current.data] + next.weight < distance[next.data]) {
					distance[next.data] = distance[current.data] + next.weight;
					queue.add(new Node(next.data, distance[next.data]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int data; // 노드의 번호
		long weight; // 걸리는 시간

		Node(int data, long weight) {
			this.data = data;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			return (int) (this.weight - o.weight);
		}
	}
}
