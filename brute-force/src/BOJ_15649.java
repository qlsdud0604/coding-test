import java.io.*;
import java.util.*;

public class BOJ_15649 {
	static int N;
	static int M;

	static boolean[] visit;
	static int[] arr;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visit = new boolean[N];
		arr = new int[M];

		dfs(0);
		System.out.println(sb);
	}

	static void dfs(int depth) {
		if (depth == M) {
			for (int data : arr) {
				sb.append(data + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i] == false) {
				visit[i] = true;

				arr[depth] = (i + 1);
				dfs(depth + 1);

				visit[i] = false;
			}
		}
	}
}
