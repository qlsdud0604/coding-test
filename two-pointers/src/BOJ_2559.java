import java.io.*;
import java.util.*;

public class BOJ_2559 {
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

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());

			if (i < K)
				max += arr[i];
		}

		twoPointers();

		bw.write(max + "\n");
		bw.close();
	}

	static void twoPointers() {
		int sum = max;

		for (int i = 0; i < N - K; i++) {
			sum = sum - arr[i] + arr[i + K];	
			
			max = Math.max(max, sum);
		}
	}
}