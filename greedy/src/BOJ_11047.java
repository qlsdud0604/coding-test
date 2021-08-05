import java.io.*;
import java.util.*;

public class BOJ_11047 {
	static int N;
	static int K;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++) {
			int A = Integer.parseInt(br.readLine());

			arr[i] = A;
		}

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int result = 0;

		for (int i = N - 1; i >= 0; i--) {
			result += K / arr[i];
			K %= arr[i];
		}

		return result;
	}

}
