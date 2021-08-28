import java.util.*;

class Solution05 {
	public int solution(int cacheSize, String[] cities) {

		/** 캐시 사이즈가 0인 경우 */
		if (cacheSize == 0)
			return cities.length * 5;

		/** 대문자 변환 */
		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toUpperCase();
		}

		int answer = 0;

		/** 캐시 생성 */
		Queue<String> queue = new LinkedList<String>();

		/** LRU 알고리즘 수행 */
		for (int i = 0; i < cities.length; i++) {
			String input = cities[i];

			/** 캐시에 자리가 있는 경우 */
			if (queue.size() < cacheSize) {
				/* hit */
				if (queue.contains(input)) {
					queue.remove(input);
					queue.add(input);
					answer += 1;
					continue;
				}
				/* miss */
				else {
					queue.add(input);
					answer += 5;
					continue;
				}
			}
			/** 캐시에 자리가 없는 경우 */
			else if (queue.size() == cacheSize) {
				/* hit */
				if (queue.contains(input)) {
					queue.remove(input);
					queue.add(input);
					answer += 1;
					continue;
				}
				/* miss */
				else {
					queue.poll();
					queue.add(input);
					answer += 5;
					continue;
				}
			}
		}

		return answer;
	}
}