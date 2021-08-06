import java.io.*;
import java.util.*;

public class BOJ_2217 {
	static int N;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N];

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {

		int[] weight = new int[N];

		for (int i = N - 1; i >= 0; i--) {
			weight[i] = arr[i] * (N - i);
		}

		Arrays.sort(weight);

		return weight[N - 1];
	}
}