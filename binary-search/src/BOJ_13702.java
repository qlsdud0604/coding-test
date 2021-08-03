import java.io.*;
import java.util.*;

public class BOJ_13702 {
	static int N;
	static int K;
	static int[] arr;

	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, arr[i]);
		}

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static int binarySearch() {
		int start = 0;
		int end = max;

		while (start <= end) {
			int middle = (start + end) / 2;
			int count = 0;

			for (int i = 0; i < N; i++) {
				count += (arr[i] / middle);
			}

			if (count >= K)
				start = middle + 1;
			else
				end = middle - 1;
		}
		return end;
	}
}