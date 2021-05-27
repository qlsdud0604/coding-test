import java.io.*;
import java.util.*;

public class BOJ_14502 {
	static int N;
	static int M;

	static int[][] arr;
	static int[][] visited;

	static int wall = 0;
	static int max = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());

				if (arr[i][j] == 1)
					wall++;
			}
		}

		makeWall(0);

		bw.write(max - 3 + "\n");
		bw.close();
	}

	/** 벽을 3개 세우자 */
	static void makeWall(int depth) {
		if (depth == 3) {

			int number = N * M - spreadVirus() - wall;

			max = Math.max(max, number);

			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					makeWall(depth + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	/** 바이러스 뿌리기 */
	static int spreadVirus() {
		int count = 0;

		visited = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 2)
					if (check(i, j))
						count += dfs(i, j);
			}
		}
		return count;
	}

	/** 바이러스가 어디까지 퍼질까? */
	static int dfs(int x, int y) {
		int value = 1;
		visited[x][y] = 1;

		if (check(x - 1, y))
			value += dfs(x - 1, y);

		if (check(x, y + 1))
			value += dfs(x, y + 1);

		if (check(x + 1, y))
			value += dfs(x + 1, y);

		if (check(x, y - 1))
			value += dfs(x, y - 1);

		return value;
	}

	/** 바이러스가 퍼질 수 있는 경로 인가? */
	static boolean check(int x, int y) {

		if (x < 0 || N <= x || y < 0 || M <= y)
			return false;

		if (visited[x][y] == 1 || arr[x][y] == 1)
			return false;

		return true;
	}
}