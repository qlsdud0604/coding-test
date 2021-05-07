import java.io.*;
import java.util.*;

public class BOJ_2230 {
	static int N;
	static int M;
	static int[] arr;

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		twoPointer();

		bw.write(result + "\n");
		bw.close();
	}

	static void twoPointer() {
		int start = 0;
		int end = 0;

		result = Integer.MAX_VALUE;

		while (true) {
			if (arr[end] - arr[start] >= M) {

				result = Math.min(result, arr[end] - arr[start++]);

				if (result == M)
					break;

			} else {
				end++;

				if (end == N)
					break;
			}
		}
	}
}