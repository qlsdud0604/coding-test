import java.io.*;
import java.util.*;

public class BOJ_1543 {
	static String input;
	static String target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		input = br.readLine();
		target = br.readLine();

		bw.write(function() + "\n");
		bw.close();
	}

	static int function() {
		int result = 0;

		for (int i = 0; i <= input.length() - target.length(); i++) {
			if (input.substring(i, i + target.length()).equals(target)) {
				result++;
				i += target.length() - 1;
			}

		}

		return result;
	}

}
