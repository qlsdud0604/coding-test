import java.io.*;
import java.util.*;

public class BOJ_1300 {
	static int N;
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static int binarySearch() {
		int start = 1;
		int end = K;

		int result = 0;

		while (start <= end) {
			int middle = (start + end) / 2;
			int count = 0;

			for (int i = 1; i <= N; i++) {
				count += Math.min(middle / i, N);
			}

			if (K <= count)
				end = middle - 1;
			else
				start = middle + 1;

		}
		return start;
	}

}
