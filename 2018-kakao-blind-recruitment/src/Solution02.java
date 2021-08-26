import java.util.*;

public class Solution02 {
	static int solution(String dartResult) {
		int[] answer = new int[3];
		int index = -1;

		for (int i = 0; i < dartResult.length(); i++) {
			char ch = dartResult.charAt(i);

			/** 점수인 경우 */
			if ('0' <= ch && ch <= '9') {
				index++;

				/* 점수가 10인 경우 */
				if (ch == '1' && dartResult.charAt(i + 1) == '0') {
					answer[index] = 10;
					i++;
				}
				/* 점수가 0 ~ 9인 경우 */
				else
					answer[index] = Integer.parseInt(ch + "");
			}
			/** 보너스인 경우 */
			else if (ch == 'S' || ch == 'D' || ch == 'T') {
				/* 보너스가 S인 경우 */
				if (ch == 'S') {
					continue;
				}
				/* 보너스가 D인 경우 */
				else if (ch == 'D') {
					answer[index] = (int) Math.pow(answer[index], 2);
				}
				/* 보너스 T인 경우 */
				else {
					answer[index] = (int) Math.pow(answer[index], 3);
				}
			}
			/** 옵션인 경우 */
			else if (ch == '*' || ch == '#') {
				/* 옵션이 *인 경우 */
				if (ch == '*') {

					if (0 < index)
						answer[index - 1] *= 2;

					answer[index] *= 2;
				}
				/* 옵션이 #인 경우 */
				else if (ch == '#') {
					answer[index] *= -1;
				}
			}
		}

		return answer[0] + answer[1] + answer[2];
	}
}
