import java.io.*;
import java.util.*;

public class BOJ_10816 {
	static int N;
	static int M;

	static int[] arrN;
	static int[] arrM;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		st = new StringTokenizer(br.readLine());

		arrN = new int[N];

		for (int i = 0; i < N; i++)
			arrN[i] = Integer.parseInt(st.nextToken());

		Arrays.sort(arrN);

		M = Integer.parseInt(br.readLine());

		arrM = new int[M];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < M; i++)
			arrM[i] = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			int lower = lowerBound(arrM[i]);
			int upper = upperBound(arrM[i]);

			bw.write((upper - lower) + " ");
		}

		bw.close();
	}

	static int lowerBound(int input) {
		int target = input;

		int first = 0;
		int last = arrN.length;

		while (first < last) {
			int middle = (first + last) / 2;

			if (target <= arrN[middle])
				last = middle;
			else
				first = middle + 1;
		}
		return first;
	}

	static int upperBound(int input) {
		int target = input;

		int first = 0;
		int last = arrN.length;

		while (first < last) {
			int middle = (first + last) / 2;

			if (arrN[middle] <= target)
				first = middle + 1;
			else
				last = middle;
		}
		return first;
	}

}
