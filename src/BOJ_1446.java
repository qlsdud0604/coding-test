import java.io.*;
import java.util.*;

public class BOJ_1446 {
	static int N; // 지름길의 개수
	static int D; // 고속도로의 길이

	static ArrayList<Node>[] list = new ArrayList[10001];
	static int[] distance = new int[10001];
	static boolean[] visited = new boolean[10001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
		}

		Arrays.fill(distance, Integer.MAX_VALUE);

		for (int i = 0; i < D; i++) {
			list[i].add(new Node(i + 1, 1));
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());

			list[start].add(new Node(end, distance));
		}

		dijkstra(0);

		bw.write(distance[D] + "\n");
		bw.close();
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		distance[start] = 0;
		queue.add(new Node(start, 0));

		while (!queue.isEmpty()) {
			Node current = queue.poll();

			if (visited[current.end] == false)
				visited[current.end] = true;
			else
				continue;

			for (int i = 0; i < list[current.end].size(); i++) {
				Node next = list[current.end].get(i);

				if (distance[current.end] + next.distance < distance[next.end]) {
					distance[next.end] = distance[current.end] + next.distance;
					queue.add(new Node(next.end, distance[next.end]));
				}
			}
		}
	}

	static class Node implements Comparable<Node> {
		int end;
		int distance;

		Node(int end, int distance) {
			this.end = end;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}
}