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

	/** 현재 징검다리 상황에서 해당 인원 수만큼 건널 수 있는지 판별하는 메서드 */
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