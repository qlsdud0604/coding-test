import java.io.*;
import java.util.*;

public class BOJ_3184 {
	static String[][] arr;
	static int R; // За
	static int C; // ї­

	static int[][] visited;

	static int[] result = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new String[R][C];
		visited = new int[R][C];

		for (int i = 0; i < R; i++) {
			String input = br.readLine();

			for (int j = 0; j < C; j++) {
				arr[i][j] = input.charAt(j) + "";
			}
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (check(i, j)) {
					int[] input = dfs(i, j);

					if (input[0] > input[1])
						result[0] += input[0];
					else
						result[1] += input[1];
				}
			}
		}

		bw.write(result[0] + " " + result[1]);
		bw.close();
	}

	static int[] dfs(int x, int y) {
		visited[x][y] = 1;

		int[] result = new int[2];

		if (arr[x][y].equals("o"))
			result[0] = 1;
		else if (arr[x][y].equals("v"))
			result[1] = 1;

		if (check(x - 1, y)) {
			int[] input = dfs(x - 1, y);

			result[0] += input[0];
			result[1] += input[1];
		}

		if (check(x, y + 1)) {
			int[] input = dfs(x, y + 1);

			result[0] += input[0];
			result[1] += input[1];
		}

		if (check(x + 1, y)) {
			int[] input = dfs(x + 1, y);

			result[0] += input[0];
			result[1] += input[1];
		}

		if (check(x, y - 1)) {
			int[] input = dfs(x, y - 1);

			result[0] += input[0];
			result[1] += input[1];
		}

		return result;
	}

	static boolean check(int x, int y) {
		if (x < 0 || R <= x || y < 0 || C <= y)
			return false;

		if (arr[x][y].equals("#") || visited[x][y] == 1)
			return false;

		return true;
	}
}
