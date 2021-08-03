import java.io.*;
import java.util.*;

public class BOJ_2512 {
	static int N;
	static int[] arr;
	static int M;

	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			max = Math.max(arr[i], max);
		}

		M = Integer.parseInt(br.readLine());

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static int binarySearch() {
		int start = 1;
		int end = max;

		while (start <= end) {
			int middle = (start + end) / 2;
			long sum = 0;

			for (int money : arr) {
				if (money <= middle)
					sum += money;
				else
					sum += middle;
			}

			if (sum <= M)
				start = middle + 1;
			else
				end = middle - 1;

		}
		return end;
	}
}
