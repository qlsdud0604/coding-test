import java.io.*;
import java.util.*;

public class BOJ_1012 {
	static int[][] arr;
	static int M; // 가로
	static int N; // 세로
	static int K; // 배추의 갯수

	static int[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int testCase = Integer.parseInt(br.readLine());

		for (int i = 0; i < testCase; i++) {
			st = new StringTokenizer(br.readLine());

			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			K = Integer.parseInt(st.nextToken()); // 배추의 갯수

			arr = new int[N][M];
			visited = new int[N][M];

			for (int j = 0; j < K; j++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				arr[y][x] = 1;
			}

			int count = 0;

			for (int j = 0; j < N; j++) {
				for (int k = 0; k < M; k++) {
					if (check(j, k)) {
						count += dfs(j, k);

					}
				}
			}
			bw.write(count + "\n");
		}
		bw.close();
	}

	static int dfs(int x, int y) {
		visited[x][y] = 1;

		if (check(x, y - 1))
			dfs(x, y - 1);

		if (check(x - 1, y))
			dfs(x - 1, y);

		if (check(x, y + 1))
			dfs(x, y + 1);

		if (check(x + 1, y))
			dfs(x + 1, y);

		return 1;
	}

	static boolean check(int x, int y) {

		if (x < 0 || N <= x || y < 0 || M <= y)
			return false;

		if (arr[x][y] == 0 || visited[x][y] == 1)
			return false;

		return true;
	}
}