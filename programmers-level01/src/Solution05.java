import java.io.*;
import java.util.*;

public class Solution05 {
	static int[] numbers;
	static boolean[] visited;
	static int[] arr = new int[3];

	static int answer = 0;

	public int solution(int[] nums) {
		numbers = nums;
		visited = new boolean[nums.length];

		dfs(0, 0);

		return answer;
	}

	/** 3���� ���ڷ� ������ �� �ִ� ��� ������ Ž�� */
	static void dfs(int start, int depth) {
		if (depth == 3) {
			int target = 0;

			for (int number : arr)
				target += number;

			if (isTrue(target))
				answer++;

			return;
		}

		for (int i = start; i < numbers.length; i++) {
			if (visited[i] == false) {
				visited[i] = true;

				arr[depth] = numbers[i];
				dfs(i, depth + 1);

				visited[i] = false;
			}
		}
	}

	/** �Ҽ��� �Ǻ��ϴ� �޼��� */
	static boolean isTrue(int target) {

		for (int i = 2; i <= target / 2; i++) {
			if (target % i == 0)
				return false;
		}

		return true;
	}
}
