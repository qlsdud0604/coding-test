import java.io.*;
import java.util.*;

public class BOJ_17266 {
	static int N;
	static int M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		arr = new int[M];

		for (int i = 0; i < M; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static int binarySearch() {
		int start = 0;
		int end = N;

		while (start <= end) {
			int middle = (start + end) / 2;
			int last = 0;

			for (int i = 0; i < M; i++) {
				if (arr[i] - last <= middle)
					last = arr[i] + middle;
			}

			if (last >= N)
				end = middle - 1;
			else
				start = middle + 1;
		}
		return start;
	}
}
