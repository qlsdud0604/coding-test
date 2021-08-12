import java.io.*;
import java.util.*;

public class BOJ_1449 {
	static int N;
	static int L;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		arr = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr);

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int result = 0;

		double range = arr[0] + L - 0.5;
		result++;

		for (int i = 1; i < N; i++) {
			if (range < arr[i] + 0.5) {
				result++;
				range = arr[i] + L - 0.5;
			}
		}

		return result;
	}

}
