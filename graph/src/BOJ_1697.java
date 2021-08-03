import java.io.*;
import java.util.*;

public class BOJ_1697 {
	static int N;
	static int K;

	static int[] arr = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr[N] = 1;

		bfs();

		bw.write((arr[K] - 1) + "\n");
		bw.close();
	}

	/* 배열 탐색 */
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);

		while (!queue.isEmpty()) {
			int x = queue.poll();

			if (x == K)
				break;

			int next01 = x + 1;
			int next02 = x - 1;
			int next03 = 2 * x;

			if (check(next01)) {
				queue.add(next01);
				arr[next01] = arr[x] + 1;
			}
			if (check(next02)) {
				queue.add(next02);
				arr[next02] = arr[x] + 1;
			}
			if (check(next03)) {
				queue.add(next03);
				arr[next03] = arr[x] + 1;
			}
		}
	}

	/* 진입 가능 여부 확인 */
	static boolean check(int x) {
		if (x < 0 || 100000 < x)
			return false;

		if (arr[x] == 0)
			return true;
		else
			return false;
	}
}
