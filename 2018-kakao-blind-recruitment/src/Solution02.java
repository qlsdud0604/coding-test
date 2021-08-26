import java.util.*;

public class Solution02 {
	static int solution(String dartResult) {
		int[] answer = new int[3];
		int index = -1;

		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);

			/** ������ ��� */
			if ('0' <= ch && ch <= '9') {
				index++;

				/* ������ 10�� ��� */
				if (ch == '1' && dartResult.charAt(i + 1) == '0') {
					answer[index] = 10;
					i++;
				}
				/* ������ 0 ~ 9�� ��� */
				else
					answer[index] = Integer.parseInt(ch + "");
			}
			/** ���ʽ��� ��� */
			else if (ch == 'S' || ch == 'D' || ch == 'T') {
				/* ���ʽ��� S�� ��� */
				if (ch == 'S') {
					continue;
				}
				/* ���ʽ��� D�� ��� */
				else if (ch == 'D') {
					answer[index] = (int) Math.pow(answer[index], 2);
				}
				/* ���ʽ� T�� ��� */
				else {
					answer[index] = (int) Math.pow(answer[index], 3);
				}
			}
			/** �ɼ��� ��� */
			else if (ch == '*' || ch == '#') {
				/* �ɼ��� *�� ��� */
				if (ch == '*') {

					if (0 < index)
						answer[index - 1] *= 2;

					answer[index] *= 2;
				}
				/* �ɼ��� #�� ��� */
				else if (ch == '#') {
					answer[index] *= -1;
				}
			}
		}

		return answer[0] + answer[1] + answer[2];
	}
}
