import java.io.*;
import java.util.*;

public class BOJ_10610 {
	static String N;
	static String[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = br.readLine();

		arr = N.split("");

		Arrays.sort(arr, Collections.reverseOrder());

		bw.write(function() + "\n");
		bw.close();
	}

	static String function() {
		String result = "";
		int sum = 0;

		boolean hasZero = false;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("0"))
				hasZero = true;

			sum += Integer.parseInt(arr[i]);
			result += arr[i];
		}

		if (sum % 3 != 0 || !hasZero)
			return "-1";

		return result;
	}

}
