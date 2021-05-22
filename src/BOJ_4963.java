import java.io.*;
import java.util.*;

public class BOJ_4963 {
	static int[][] arr;

	static int w;
	static int h;

	static int[][] visited;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());

			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0)
				break;

			arr = new int[h][w];
			visited = new int[h][w];

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());

				for (int j = 0; j < w; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			count = 0;

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (check(i, j))
						count += dfs(i, j);
				}
			}
			bw.write(count + "\n");
		}
		bw.close();
	}

	static int dfs(int x, int y) {
		visited[x][y] = 1;

		if (check(x - 1, y - 1))
			dfs(x - 1, y - 1);

		if (check(x - 1, y))
			dfs(x - 1, y);

		if (check(x - 1, y + 1))
			dfs(x - 1, y + 1);

		if (check(x, y + 1))
			dfs(x, y + 1);

		if (check(x + 1, y + 1))
			dfs(x + 1, y + 1);

		if (check(x + 1, y))
			dfs(x + 1, y);

		if (check(x + 1, y - 1))
			dfs(x + 1, y - 1);

		if (check(x, y - 1))
			dfs(x, y - 1);

		return 1;
	}

	static boolean check(int x, int y) {

		if (x < 0 || h <= x || y < 0 || w <= y)
			return false;

		if (arr[x][y] == 0 || visited[x][y] == 1)
			return false;

		return true;
	}

}
