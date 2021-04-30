import java.io.*;
import java.util.*;

public class BOJ_2110 {
	static int N;
	static int C;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		bw.write(binarySearch() + "\n");
		bw.close();
	}

	static int binarySearch() {
		int start = 1;
		int end = (arr[N - 1] - arr[0]);

		while (start <= end) {
			int middle = (start + end) / 2;
			int count = 1;
			int current = arr[0];

			for (int i = 0; i < N; i++) {
				if (arr[i] - current >= middle) {
					count++;
					current = arr[i];
				}
			}

			if (count >= C)
				start = middle + 1;
			else
				end = middle - 1;
		}
		return end;
	}
}
