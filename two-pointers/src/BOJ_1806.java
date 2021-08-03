import java.io.*;
import java.util.*;

public class BOJ_1806 {
	static int N;
	static int S;
	static int[] arr;

	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());

		result = N + 1;

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		twoPointers();

		if (result == N + 1)
			bw.write(0 + "\n");
		else
			bw.write(result + "\n");

		bw.close();
	}

	static void twoPointers() {
		int left = 0;
		int right = 0;

		int sum = 0;

		while (true) {
			if (S <= sum) {
				sum -= arr[left];
				result = Math.min(result, right - left);
				left++;
			} else if (right == N)
				break;
			else {
				sum += arr[right];
				right++;
			}
		}
	}
}
