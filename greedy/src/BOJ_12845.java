import java.io.*;
import java.util.*;

public class BOJ_12845 {
	static int N;
	static Integer[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new Integer[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arr, Collections.reverseOrder());

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int result = 0;

		for (int i = 1; i < N; i++) {
			result += arr[0] + arr[i];
		}

		return result;
	}

}
