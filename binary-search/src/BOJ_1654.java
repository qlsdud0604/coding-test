import java.io.*;
import java.util.*;

public class BOJ_1654 {
	static int K;
	static int N;

	static long[] lans;

	static long max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		lans = new long[K];

		for (int i = 0; i < K; i++) {
			lans[i] = Long.parseLong(br.readLine());
			max = Math.max(max, lans[i]);
		}

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static long binarySearch() {
		long start = 1;
		long end = max;

		while (start <= end) {
			long middle = (start + end) / 2;
			long sum = 0;

			for (long lan : lans)
				sum += (lan / middle);

			if (sum < N)
				end = middle - 1;
			else if (N <= sum)
				start = middle + 1;

		}
		return end;
	}
}
