import java.io.*;
import java.util.*;

public class BOJ_2805 {
	static int N;
	static int M;

	static int[] trees;

	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		trees = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, trees[i]);
		}

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static int binarySearch() {
		int start = 0;
		int end = max;

		while (start <= end) {
			int middle = (start + end) / 2;
			long sum = 0;

			for (int tree : trees) {

				if (tree >= middle) {
					sum += (tree - middle);
				}
			}

			if (sum < M)
				end = middle - 1;
			else if (M < sum)
				start = middle + 1;
			else
				return middle;
		}
		return end;
	}
}
