import java.io.*;
import java.util.*;

class Solution03 {
	static Queue<String> queue = new LinkedList<>();
	static Set<String> set = new HashSet<>();
	static Map<String, Integer> map = new HashMap<>();

	static int length = Integer.MAX_VALUE;
	static int left = 0;

	public int[] solution(String[] gems) {

		/** �����뿡 ���õ� �������� ������ �ľ� */
		for (String gem : gems) {
			set.add(gem);
		}

		int start = 0;

		/** �����뿡 ���õ� �������� �ϳ��� Ž�� */
		for (int i = 0; i < gems.length; i++) {

			/* ���� ������ map�� ���� ��� */
			if (!map.containsKey(gems[i])) {
				map.put(gems[i], 1);
			}
			/* ���� ������ map�� �ִ� ��� */
			else {
				map.put(gems[i], map.get(gems[i]) + 1);
			}

			/* queue�� ���� */
			queue.add(gems[i]);

			/* queue�� �������� Ž�� */
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