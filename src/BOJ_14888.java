import java.io.*;
import java.util.*;

public class BOJ_14888 {
	static int n;
	static int[] number;
	static int[] operator = new int[4];

	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;

	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		n = Integer.parseInt(br.readLine());

		number = new int[n];
		arr = new int[n - 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			number[i] = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());

		dfs(0);

		bw.write(max + "\n");
		bw.write(min + "\n");
		bw.close();

	}

	static void dfs(int depth) {

		int result = number[0];

		if (depth == n - 1) {
			for (int i = 1; i < n; i++) {
				if (arr[i - 1] == 0) {
					result += number[i];
				} else if (arr[i - 1] == 1) {
					result -= number[i];
				} else if (arr[i - 1] == 2) {
					result *= number[i];
				} else if (arr[i - 1] == 3) {
					result /= number[i];
				}
			}
			max = Math.max(result, max);
			min = Math.min(result, min);
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operator[i] != 0) {
				operator[i]--;

				arr[depth] = i;
				dfs(depth + 1);

				operator[i]++;
			}
		}

	}
}
