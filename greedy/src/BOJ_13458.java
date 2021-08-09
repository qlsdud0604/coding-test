import java.io.*;
import java.util.*;

public class BOJ_13458 {
	static int N;
	static int[] arr;
	static int B;
	static int C;

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

		st = new StringTokenizer(br.readLine());

		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		bw.write(function() + "\n");
		bw.close();

	}

	static long function() {
		long result = 0;

		for (int i = 0; i < N; i++) {

			if (arr[i] <= B)
				result++;
			else {
				result++;

				arr[i] -= B;

				if (arr[i] % C == 0)
					result += arr[i] / C;
				else
					result += arr[i] / C + 1;
			}
		}

		return result;
	}

}
