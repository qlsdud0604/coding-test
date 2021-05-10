import java.io.*;
import java.util.*;

public class BOJ_13144 {
	static int N;
	static int[] arr;

	static boolean[] check = new boolean[100001];
	static long count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		twoPointers();

		bw.write(count + "\n");
		bw.close();
	}

	static void twoPointers() {
		int start = 0;
		int end = 0;

		while (true) {
			if (end == N) {
				count += (end - start);
				start++;

				if (start == N)
					break;
			} else if (!check[arr[end]])
				check[arr[end++]] = true;
			else if (check[arr[end]]) {
				count += (end - start);

				check[arr[start++]] = false;
			}
		}
	}
}
