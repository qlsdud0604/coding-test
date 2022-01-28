import java.io.*;
import java.util.*;

class Solution10 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int total = brown + yellow;

		for (int col = 3; col < total; col++) {

			/* row�� ��Ȯ�� ������ �������� ���(������ ���) */
			if (total % col == 0) {
				int row = total / col;

				/* ����� ������ ���� ��ġ�ϴ� ��� */
				if (col <= row && (row - 2) * (col - 2) == yellow) {
					answer[0] = row;
					answer[1] = col;

					break;
				}
			}
		}

		return answer;
	}

}
