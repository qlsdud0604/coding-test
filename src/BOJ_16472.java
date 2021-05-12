import java.io.*;
import java.util.*;

public class BOJ_16472 {
	static int N;
	static String string;

	static int result = 0;

	static int[] check = new int[26];
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		string = br.readLine();

		twoPointers();

		bw.write(result + "\n");
		bw.close();
	}

	static void twoPointers() {

		for (int start = 0, end = 0; end < string.length(); end++) {
			add(string.charAt(end));

			while (N < count) {
				delete(string.charAt(start++));
			}

			result = Math.max(result, end - start + 1);
		}
	}

	static void add(char ch) {
		check[ch - 97]++;

		if (check[ch - 97] == 1)
			count++;
	}

	static void delete(char ch) {
		check[ch - 97]--;

		if (check[ch - 97] == 0)
			count--;
	}
}