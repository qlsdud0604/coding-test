import java.io.*;
import java.util.*;

public class BOJ_1439 {
	static String S;
	static String string = "";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		S = br.readLine();

		for (int i = 0; i < S.length(); i++) {
			if (string.equals(""))
				string += S.charAt(i);
			else {
				if (string.charAt(string.length() - 1) != S.charAt(i))
					string += S.charAt(i);
			}

		}

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int zero = 0;
		int one = 0;

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '0')
				zero++;
			else
				one++;
		}

		return zero < one ? zero : one;
	}

}
