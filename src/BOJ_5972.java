import java.io.*;
import java.util.*;

public class BOJ_5972 {
	static int N; // 헛간의 개수
	static int M; // 길의 개수

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

		list = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			list[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			list[A].add(new Node(B, C));
			list[B].add(new Node(A, C));
		}

		dijkstra(1);

		bw.write(distance[N] + "\n");
		bw.close();
	}

	static void dijkstra(int start) {
		/* 초기화 */
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);

		/* 다익스트라 */
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
	}

	static class Node implements Comparable<Node> {
		int data; // 노드의 번호
		int weight; // 현재 노드로 이동하기 위한 가중치

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