import java.io.*;
import java.util.*;

public class Solution01 {
	public int[] solution(int[] lottos, int[] win_nums) {

		int correct_count = 0; // ��÷ ��ȣ�� ��ġ�ϴ� ��ȣ�� ��
		int zero_count = 0; // �˾ƺ� �� ���� ��ȣ(0)�� ��

		for (int i = 0; i < lottos.length; i++) {
			int lotto = lottos[i];

			if (lotto == 0) {
				zero_count++;
				continue;
			}

			for (int j = 0; j < win_nums.length; j++) {
				if (lotto == win_nums[j]) {
					correct_count++;
				}
			}
		}

		int max = 7 - (correct_count + zero_count);

		if (correct_count + zero_count <= 1)
			max = 6;

		int min = 7 - correct_count;

		if (correct_count <= 1)
			min = 6;

		int[] answer = new int[2];

		answer[0] = max;
		answer[1] = min;

		return answer;
	}
}
