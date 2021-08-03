import java.io.*;
import java.util.*;

public class BOJ_2003 {
	static int N;
	static int M;
	static int[] arr;

	static int count = 0;

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
		}

		twoPointers();

		bw.write(count + "\n");
		bw.close();
	}

	static void twoPointers() {
		int start = 0;
		int end = 0;

		int sum = 0;

		while (true) {
			if (M < sum)
				sum -= arr[start++];
			else if (end == N)
				break;
			else
				sum += arr[end++];

			if (sum == M)
				count++;
		}
	}
}