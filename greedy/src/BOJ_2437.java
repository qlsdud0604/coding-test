import java.io.*;
import java.util.*;

public class BOJ_2437 {
	static int N;
	static int[] arr;

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

		Arrays.sort(arr);

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int result = 0;

		for (int i = 0; i < N; i++) {
			if (result + 1 < arr[i])
				break;
			else
				result += arr[i];
		}

		return result + 1;
	}

}