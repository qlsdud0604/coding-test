import java.io.*;
import java.util.*;

public class BOJ_9663 {
	static int N;
	static int[] arr;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		dfs(0);

		bw.write(count + "");
		bw.close();
	}

	static void dfs(int depth) {
		if (depth == N) {
			count++;
			return;
		}

		for (int i = 0; i < N; i++) {
			arr[depth] = i;

			if (possible(depth)) {
				dfs(depth + 1);
			}
		}
	}

	static boolean possible(int col) {
		for (int i = 0; i < col; i++) {
			if (arr[i] == arr[col])
				return false;
		}

		for (int i = 0; i < col; i++) {
			if (Math.abs(arr[i] - arr[col]) == Math.abs(i - col))
				return false;
		}

		return true;
	}
}
