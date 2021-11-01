import java.io.*;
import java.util.*;

class Solution03 {
	static Queue<String> queue = new LinkedList<>();
	static Set<String> set = new HashSet<>();
	static Map<String, Integer> map = new HashMap<>();

	static int length = Integer.MAX_VALUE;
	static int left = 0;

	public int[] solution(String[] gems) {

		/** 진열대에 전시된 보석들의 종류를 파악 */
		for (String gem : gems) {
			set.add(gem);
		}

		int start = 0;

		/** 진열대에 전시된 보석들을 하나씩 탐색 */
		for (int i = 0; i < gems.length; i++) {

			/* 현재 보석이 map에 없는 경우 */
			if (!map.containsKey(gems[i])) {
				map.put(gems[i], 1);
			}
			/* 현재 보석이 map에 있는 경우 */
			else {
				map.put(gems[i], map.get(gems[i]) + 1);
			}

			/* queue에 삽입 */
			queue.add(gems[i]);

			/* queue의 보석들을 탐색 */
			while (true) {
				String gem = queue.peek();

				if (1 < map.get(gem)) {
					map.put(gem, map.get(gem) - 1);
					queue.poll();

					left++;
				} else {
					break;
				}
			}

			if (map.size() == set.size() && queue.size() < length) {
				start = left;
				length = queue.size();
			}
		}

		return new int[] { start + 1, start + length };
	}
}