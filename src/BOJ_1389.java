import java.io.*;
import java.util.*;

public class BOJ_1389 {
	static int N;
	static int M;

	static int[][] arr;
	static boolean[] visited;

	static ArrayList<Person> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		for (int i = 1; i <= N; i++) {
			visited = new boolean[N + 1];

			list.add(new Person(i, bfs(i)));
		}

		Collections.sort(list);

		bw.write(list.get(0).number + "\n");
		bw.close();
	}

	static int bfs(int start) {
		int result = 0;

		Queue<Person> queue = new LinkedList<Person>();
		queue.add(new Person(start, 0));
		visited[start] = true;

		while (!queue.isEmpty()) {
			Person person = queue.poll();

			result += person.count;

			for (int i = 1; i <= N; i++) {
				if (arr[person.number][i] == 1 && visited[i] == false) {
					visited[i] = true;
					queue.add(new Person(i, person.count + 1));
				}
			}
		}

		return result;
	}

	static class Person implements Comparable<Person> {
		int number;
		int count;

		Person(int number, int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(Person o) {
			if (this.count > o.count)
				return 1;
			else if (this.count == o.count) {
				if (this.number > o.number)
					return 1;
				else
					return -1;

			} else
				return -1;
		}
	}
}
