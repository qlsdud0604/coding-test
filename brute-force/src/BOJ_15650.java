import java.util.*;
import java.io.*;

public class BOJ_15650 {
	static int n;
	static int m;

	static boolean[] visit;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		visit = new boolean[n];

		dfs(0, 0);
		System.out.print(sb);
	}

	static void dfs(int start, int depth) {
		if (depth == m) {
			for (int i = 0; i < n; i++) {
				if (visit[i] == true)
					sb.append((i + 1) + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < n; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				dfs(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}
