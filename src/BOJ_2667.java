import java.io.*;
import java.util.*;

public class BOJ_2667 {
	static int N;
	static int[][] arr;

	static int[][] visited;
	static ArrayList<Integer> list = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][N];
		visited = new int[N][N];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();

			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(input.charAt(j) + "");
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check(i, j)) {
					int result = dfs(i, j);

					list.add(result);
				}
			}
		}

		Collections.sort(list);

		bw.write(list.size() + "\n");

		for (int result : list)
			bw.write(result + "\n");

		bw.close();
	}

	static int dfs(int i, int j) {
		int value = 1;
		visited[i][j] = 1;

		if (check(i - 1, j))
			value += dfs(i - 1, j);

		if (check(i, j - 1))
			value += dfs(i, j - 1);

		if (check(i + 1, j))
			value += dfs(i + 1, j);

		if (check(i, j + 1))
			value += dfs(i, j + 1);

		return value;
	}

	static boolean check(int i, int j) {
		if (i < 0 || N <= i || j < 0 || N <= j)
			return false;

		if (visited[i][j] == 1 || arr[i][j] == 0)
			return false;

		return true;
	}
}
