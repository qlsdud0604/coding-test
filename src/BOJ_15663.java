import java.io.*;
import java.util.*;

public class BOJ_15663 {
	static int N;
	static int M;

	static int[] number;
	static boolean[] visit;
	static int[] arr;

	static StringBuilder sb = new StringBuilder();

	static LinkedHashSet<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		number = new int[N];
		visit = new boolean[N];
		arr = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			number[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(number);

		dfs(0);

		for (String string : set)
			sb.append(string + "\n");

		System.out.print(sb);
	}

	static void dfs(int depth) {
		if (depth == M) {
			String result = "";
			for (int data : arr)
				result += data + " ";

			set.add(result);

			return;
		}

		for (int i = 0; i < N; i++) {
			if (visit[i] == false) {
				visit[i] = true;

				arr[depth] = number[i];

				dfs(depth + 1);

				visit[i] = false;
			}
		}
	}
}
