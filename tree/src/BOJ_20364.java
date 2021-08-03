import java.io.*;
import java.util.*;

public class BOJ_20364 {
	static int N;
	static int Q;

	static HashSet<Integer> set = new HashSet();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		for (int i = 0; i < Q; i++) {
			int input = Integer.parseInt(br.readLine());

			bw.write(check(input) + "\n");
		}
		bw.close();

	}

	static int check(int input) {
		int number = input;

		int result = 0;

		while (true) {

			if (number == 0)
				break;

			if (set.contains(number))
				result = number;

			number = number / 2;
		}

		if (result == 0)
			set.add(input);

		return result;
	}
}
