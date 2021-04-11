import java.io.*;
import java.util.*;

public class BOJ_2470 {
	static int N;

	static int[] arr;

	static int[] result = new int[2];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		/** 입력 */
		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		/** 출력 */
		function();

		bw.write(result[0] + " " + result[1]);
		bw.close();

	}

	static void function() {
		
		int max = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			int first = i + 1;
			int last = arr.length - 1;

			while (first <= last) {
				int middle = (first + last) / 2;

				int sum = arr[i] + arr[middle];

				if (Math.abs(sum) < max) {
					result[0] = arr[i];
					result[1] = arr[middle];

					max = Math.abs(sum);
				}

				if (sum < 0)
					first = middle + 1;
				else
					last = middle - 1;
			}
		}
	}
}
