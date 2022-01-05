import java.io.*;
import java.util.*;

public class Solution05 {
	static int[] numbers;
	static int target;

	static boolean[] operators;

	static int answer = 0;

	public int solution(int[] input01, int input02) {
		numbers = input01;
		target = input02;

		operators = new boolean[numbers.length];

		dfs(0, 0);

		return answer;
	}

	/** 더하기, 빼기 연산의 모든 조합을 탐색 */
	static void dfs(int depth, int index) {
		if (depth == operators.length) {
			int sum = 0;

			for (int i = 0; i < operators.length; i++) {
				if (operators[i])
					sum += numbers[i];
				else
					sum -= numbers[i];
			}

			if (sum == target)
				answer++;

			return;
		}

		operators[index] = true;

		dfs(depth + 1, index + 1);

		operators[index] = false;

		dfs(depth + 1, index + 1);
	}
}
