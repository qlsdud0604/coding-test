import java.io.*;
import java.util.*;

public class Solution09 {
	public int solution(int n, int[] lost, int[] reserve) {

		int[] person = new int[n + 2];
		Arrays.fill(person, 1);
		person[0] = 0;
		person[n + 1] = 0;

		for (int number : lost)
			person[number]--;

		for (int number : reserve)
			person[number]++;

		for (int i = 1; i < person.length - 1; i++) {
			/** ü������ ���� �л��� ��� */
			if (person[i] == 0) {
				/* �ջ���� ������ ü������ �ִ��� Ȯ�� */
				if (person[i - 1] == 2) {
					person[i - 1] = 1;
					person[i] = 1;
					continue;
				}

				/* �޻���� ������ ü������ �ִ��� Ȯ�� */
				if (person[i + 1] == 2) {
					person[i + 1] = 1;
					person[i] = 1;
					continue;
				}
			}
		}

		int answer = 0;

		for (int i = 1; i < person.length - 1; i++)
			if (person[i] != 0)
				answer++;

		return answer;
	}
}
