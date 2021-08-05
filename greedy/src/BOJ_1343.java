import java.io.*;
import java.util.*;

public class BOJ_1343 {
	static String S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		S = br.readLine();
		S += ".";

		String result = function();

		if (result.equals("-1"))
			bw.write(result + "\n");
		else
			bw.write(result.substring(0, result.length() - 1) + "\n");
		bw.close();
	}

	static String function() {
		String result = "";

		int count = 0;

		for (int i = 0; i < S.length(); i++) {
			if (S.charAt(i) == 'X')
				count++;
			else {
				/* 덮을 수 없는 경우 */
				if (count % 2 != 0)
					return "-1";
				/* 덮을 수 있는 경우 */
				else {
					for (int j = 0; j < count / 4; j++)
						result += "AAAA";

					count %= 4;

					for (int j = 0; j < count / 2; j++)
						result += "BB";
				}

				if (S.charAt(i) == '.')
					result += ".";

				count = 0;
			}
		}

		return result;
	}

}
