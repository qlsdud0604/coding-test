import java.util.*;

public class Solution09 {
	static String[] alphabet = { "A", "B", "C", "D", "E", "F" };

	public String solution(int n, int t, int m, int p) {
		StringBuilder sb = new StringBuilder("0");

		int number = 1; // 1���� ����

		/** n������ ��ȯ */
		while (sb.length() <= t * m) {
			StringBuilder temp = new StringBuilder();

			int x = number;
			int y = 0;

			while (0 < x) {
				y = x % n;
				x = x / n;

				/* �������� 10�̻� 15������ ������ ��� */
				if (10 <= y && y <= 15)
					temp.append(alphabet[y - 10]);

				/* �������� 10�̸��� ������ ��� */
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
