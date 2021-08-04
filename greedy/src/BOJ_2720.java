import java.io.*;
import java.util.*;

public class BOJ_2720 {
	static int T;
	static int C;

	static int[] arr = { 25, 10, 5, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			C = Integer.parseInt(br.readLine());

			int[] result = function(C);

			for (int j = 0; j < 4; j++) {
				bw.write(result[j] + " ");
			}
			bw.write("\n");
		}
		bw.close();
	}

	static int[] function(int n) {
		int[] result = new int[4];

		for (int i = 0; i < 4; i++) {
			result[i] = n / arr[i];
			n %= arr[i];
		}

		return result;
	}

}
