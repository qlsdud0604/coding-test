import java.io.*;
import java.util.*;

public class BOJ_1083 {
	static int N;
	static int[] arr;
	static int S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		S = Integer.parseInt(br.readLine());

		function();
	}

	static void function() {

		for (int i = 0; i < N; i++) {
			int max = arr[i];
			int maxIndex = i;

			for (int j = i + 1; j < N; j++) {
				if (S >= j - i) {
					if (max < arr[j]) {
						max = arr[j];
						maxIndex = j;
					}
				}
			}

			for (int j = maxIndex; j > i; j--) {
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
			}

			S -= maxIndex - i;

			if (S == 0)
				break;
		}

		for (int i = 0; i < N; i++)
			System.out.print(arr[i] + " ");
	}

}
