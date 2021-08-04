import java.io.*;
import java.util.*;

public class BOJ_2839 {
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int result = 0;

		while (true) {
			if (N % 5 == 0) {
				result += N / 5;
				break;
			} else if (N < 0) {
				result = -1;
				break;
			}

			N -= 3;
			result++;
		}

		return result;
	}

}
