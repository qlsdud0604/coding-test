import java.io.*;
import java.util.*;

public class BOJ_2473 {
	static int N;
	static long[] arr;

	static long[] result = new long[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new long[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		twoPointers();

		for (long i : result)
			bw.write(i + " ");

		bw.close();

	}

	static void twoPointers() {
		long min = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			int start = i + 1;
			int end = N - 1;

			while (start < end) {
				long sum = arr[i] + arr[start] + arr[end];

				if (Math.abs(sum) < min) {
					result[0] = arr[i];
					result[1] = arr[start];
					result[2] = arr[end];

					min = Math.abs(sum);
				}

				if (sum < 0)
					start++;
				else if (0 < sum)
					end--;
				else if (sum == 0) {
					System.out.println(arr[i] + " " + arr[start] + " " + arr[end]);
					return;
				}
			}
		}
	}
}