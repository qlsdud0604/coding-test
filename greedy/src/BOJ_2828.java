import java.io.*;
import java.util.*;

public class BOJ_2828 {
	static int N;
	static int M;
	static int J;

	static int[] arr;
	static int result = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		J = Integer.parseInt(br.readLine());
		arr = new int[J];

		for (int i = 0; i < J; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		function();

		bw.write(result + "\n");
		bw.close();
	}

	static void function() {
		int left = 1;
		int right = M;

		for (int i = 0; i < J; i++) {
			int apple = arr[i];

			if (left <= apple && apple <= right) {
				result += 0;
			} else if (apple < left) {
				result += left - apple;

				left = apple;
				right = left + M - 1;
			} else if (right < apple) {
				result += apple - right;

				right = apple;
				left = right - M + 1;
			}
		}
	}

}
