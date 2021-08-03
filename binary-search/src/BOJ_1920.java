import java.util.*;
import java.io.*;

public class BOJ_1920 {
	static int N;
	static long[] arrN;

	static int M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arrN = new long[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++)
			arrN[i] = Long.parseLong(st.nextToken());

		Arrays.sort(arrN);

		M = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++) {
			long parameter = Long.parseLong(st.nextToken());

			int result = function(parameter);
			bw.write(result + "\n");
		}
		bw.close();
	}

	static int function(long parameter) {

		long target = parameter;

		int first = 0;
		int last = N - 1;

		while (first <= last) {
			int middle = (first + last) / 2;

			if (arrN[middle] < target)
				first = middle + 1;
			else if (arrN[middle] > target)
				last = middle - 1;
			else
				return 1;

		}
		return 0;
	}
}
