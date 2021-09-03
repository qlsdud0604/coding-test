import java.util.*;

public class Solution09 {
	static String[] alphabet = { "A", "B", "C", "D", "E", "F" };

	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder("0");

		int number = 1; // 1부터 시작

		/** n진수로 변환 */
		while (sb.length() <= t * m) {
			StringBuilder temp = new StringBuilder();

			int x = number;
			int y = 0;

			while (0 < x) {
				y = x % n;
				x = x / n;

				/* 나머지가 10이상 15이하의 숫자인 경우 */
				if (10 <= y && y <= 15)
					temp.append(alphabet[y - 10]);

				/* 나머지가 10미만의 숫자인 경우 */
				else
					temp.append(y);
			}
			number++;
			sb.append(temp.reverse());
		}

		StringBuilder answer = new StringBuilder();

		for (int i = p - 1; i < sb.length(); i += m) {
			answer.append(sb.charAt(i));

			if (answer.length() == t)
				break;
		}

		return answer.toString();
	}
}
