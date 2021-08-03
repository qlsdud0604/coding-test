import java.io.*;
import java.util.*;

public class BOJ_5567 {
	static int N;
	static int M;

	static int[][] arr;
	static boolean[] visited;

	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		bfs();

		bw.write(result + "\n");
		bw.close();
	}

	static void bfs() {
		Queue<Person> queue = new LinkedList<Person>();
		queue.add(new Person(1, 0));

		while (!queue.isEmpty()) {
			Person person = queue.poll();
			visited[person.number] = true;

			if (2 < person.count)
				break;

			if (1 <= person.count && person.count <= 2)
				result++;

			for (int i = 1; i <= N; i++) {
				if (arr[person.number][i] == 1 && visited[i] == false) {
					queue.add(new Person(i, person.count + 1));
					visited[i] = true;
				}
			}
		}
	}

	static class Person {
		int number;
		int count;

		Person(int number, int count) {
			this.number = number;
			this.count = count;
		}
	}
}
