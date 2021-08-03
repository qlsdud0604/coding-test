import java.io.*;
import java.util.*;

public class BOJ_1253 {
	static int N;
	static int[] arr;

	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		twoPointers();

		bw.write(count + "\n");
		bw.close();
	}

	static void twoPointers() {

		for (int i = 0; i < N; i++) {
			int start = 0;
			int end = N - 1;

			int target = arr[i];

			while (start < end) {
				if (arr[start] + arr[end] < target)
					start++;
				else if (target < arr[start] + arr[end])
					end--;
				else {
					if (start != i && end != i) {
						count++;
						break;
					}

					if (start == i)
						start++;

					if (end == i)
						end--;

				}
			}
		}
	}
}
