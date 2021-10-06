import java.util.*;

class Solution05 {
	static int answer = 0;

	static int first = 1;
	static int last = 200000000;
	static int mid = 0;

	public int solution(int[] stones, int k) {

		while (first <= last) {
			mid = (first + last) / 2;

			if (!cross(stones, k, mid)) {
				last = mid - 1;
			} else {
				first = mid + 1;
				answer = Math.max(answer, mid);
			}
		}
		return answer;
	}

	/** ���� ¡�˴ٸ� ��Ȳ���� �ش� �ο� ����ŭ �ǳ� �� �ִ��� �Ǻ��ϴ� �޼��� */
	static boolean cross(int[] stones, int k, int friends) {
		int steps = 0;

		for (int i = 0; i < stones.length; i++) {
			int stone = stones[i];

			if (stone - friends < 0) {
				steps++;
			} else {
				steps = 0;
			}

			if (steps == k)
				return false;
		}

		return true;
	}
}