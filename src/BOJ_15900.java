import java.io.*;
import java.util.*;

public class BOJ_15900 {
	static int N;
	static LinkedList<Integer>[] list;
	static boolean[] visited;

	static int sum = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		list = new LinkedList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			list[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());

			int input01 = Integer.parseInt(st.nextToken());
			int input02 = Integer.parseInt(st.nextToken());

			list[input01].add(input02);
			list[input02].add(input01);
		}

		dfs(1, 0);

		if (sum % 2 == 0)
			bw.write("No" + "\n");
		else
			bw.write("Yes" + "\n");
		
		bw.close();
	}

	static void dfs(int root, int depth) {

		visited[root] = true;

		boolean isLeaf = true;

		for (int data : list[root]) {
			if (visited[data] == false) {
				visited[data] = true;
				isLeaf = false;

				dfs(data, depth + 1);
			}
		}

		if (isLeaf)
			sum += depth;
	}

}
