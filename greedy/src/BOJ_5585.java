import java.io.*;
import java.util.*;

public class BOJ_5585 {
	static int N = 1000;
	static int result = 0;

	static int[] arr = { 500, 100, 50, 10, 5, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int input = Integer.parseInt(br.readLine());

		N -= input;

		function(N);

		bw.write(result + "\n");
		bw.close();
	}

	static void function(int n) {

		for (int i = 0; i < arr.length; i++) {
			result += n / arr[i];
			n %= arr[i];
		}
	}

}
