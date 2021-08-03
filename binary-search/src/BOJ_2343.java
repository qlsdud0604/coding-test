import java.io.*;
import java.util.*;

public class BOJ_2343 {
	static int N;
	static int M;
	static int[] arr;

	static int max = 0;
	static int total = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			total += arr[i];
			max = Math.max(arr[i], max);
		}

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static int binarySearch() {
		int start = max;
		int end = total;

		while (start <= end) {
			int middle = (start + end) / 2;

			int count = 0;
			int sum = 0;

			for (int i = 0; i < N; i++) {
				if (sum + arr[i] > middle) {
					sum = 0;
					count++;
				}

				sum += arr[i];
			}

			if (sum > 0)
				count++;

			if (count <= M)
				end = middle - 1;
			else
				start = middle + 1;
		}
		return start;
	}
}