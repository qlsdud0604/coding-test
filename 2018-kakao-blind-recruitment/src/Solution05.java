import java.util.*;

class Solution05 {
	public int solution(int cacheSize, String[] cities) {

		/** ĳ�� ����� 0�� ��� */
		if (cacheSize == 0)
			return cities.length * 5;

		/** �빮�� ��ȯ */
		for (int i = 0; i < cities.length; i++) {
			cities[i] = cities[i].toUpperCase();
		}

		int answer = 0;

		/** ĳ�� ���� */
		Queue<String> queue = new LinkedList<String>();

		/** LRU �˰��� ���� */
		for (int i = 0; i < cities.length; i++) {
			String input = cities[i];

			/** ĳ�ÿ� �ڸ��� �ִ� ��� */
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
			/** ĳ�ÿ� �ڸ��� ���� ��� */
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