import java.io.*;
import java.util.*;

public class BOJ_7795 {
	static int N;

	static int n;
	static int m;

	static int[] A;
	static int[] B;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int count = 0;

			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			A = new int[n];
			B = new int[m];

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < n; j++)
				A[j] = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < m; j++)
				B[j] = Integer.parseInt(st.nextToken());

			for (int j = 0; j < n; j++) {
				count += getCount(A[j]);
			}

			bw.write(count + "\n");
		}
		bw.close();
	}

	/** 배열 A의 각 원소보다 작은 배열 B의 원소의 개수를 반환하는 메소드 */
	static int getCount(int element) {
		Arrays.sort(B);

		int target = element;

		int first = 0;
		int last = m - 1;

		int result = 0;

		while (first <= last) {
			int mid = (first + last) / 2;

			if (B[mid] < target) {
				first = mid + 1;

				result = mid + 1;
			} else {
				last = mid - 1;
			}
		}

		return result;
	}
}