import java.io.*;
import java.util.*;

class Solution10 {
	public int[] solution(int brown, int yellow) {
		int[] answer = new int[2];

		int total = brown + yellow;

		for (int col = 3; col < total; col++) {

			/* row가 정확히 나누어 떨어지는 경우(정수인 경우) */
			if (total % col == 0) {
				int row = total / col;

				/* 노란색 격자의 수와 일치하는 경우 */
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
