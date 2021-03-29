import java.io.*;
import java.util.*;

public class BOJ_1759 {
	static int L;
	static int C;

	static String[] string;
	static boolean[] visit;

	static String compare = "aeiou";

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		string = new String[C];
		visit = new boolean[C];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++)
			string[i] = st.nextToken();

		Arrays.sort(string);

		dfs(0, 0);

		System.out.print(sb);
	}

	static void dfs(int start, int depth) {
		if (depth == L) {
			int count = 0;
			String result = "";

			for (int i = 0; i < C; i++) {
				if (visit[i] == true)
					result += string[i];
			}

			for (int i = 0; i < L; i++) {
				if (!compare.contains(result.charAt(i) + ""))
					count++;
			}

			if ((result.contains("a") || result.contains("e") || result.contains("i") || result.contains("o")
					|| result.contains("u")) && count >= 2)
				sb.append(result + "\n");

			return;
		}

		for (int i = start; i < C; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				dfs(i, depth + 1);
				visit[i] = false;
			}
		}
	}
}
