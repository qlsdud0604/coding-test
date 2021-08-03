import java.io.*;
import java.util.*;

public class BOJ_1182 {
	static int N;
	static int S;

	static int[] number;
	static boolean[] visit;

	static int count = 0;

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		number = new int[N];
		visit = new boolean[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			number[i] = Integer.parseInt(st.nextToken());

		dfs(0, 0);

		bw.write(count + "\n");
		bw.close();
	}

	static void dfs(int start, int depth) {

		if (0 < depth && depth <= N) {
			int result = 0;
			for (int i = 0; i < N; i++) {
				if (visit[i] == true) {
					result += number[i];
				}
			}
			if (result == S)
				count++;
		}

		for (int i = start; i < N; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				dfs(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}
