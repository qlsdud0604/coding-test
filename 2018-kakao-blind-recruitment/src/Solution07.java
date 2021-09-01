import java.util.*;

public class Solution07 {
	static HashMap<String, Integer> map = new HashMap<>();

	public ArrayList<Integer> solution(String msg) {
		ArrayList<Integer> answer = new ArrayList<>();

		/** HashMap에 A ~ Z 저장 */
		int value = 1;

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			map.put(ch + "", value++);
		}

		/** 주어진 문자열 탐색 */
		for (int i = 0; i < msg.length(); i++) {
			int index = 1;

			while (i + index <= msg.length() && map.containsKey(msg.substring(i, i + index))) {
				index++;
			}

			if (msg.length() < i + index) {
				answer.add(map.get(msg.substring(i)));
				break;
			}

			answer.add(map.get(msg.substring(i, i + index - 1)));
			map.put(msg.substring(i, i + index), value++);

			if (1 < index)
				i += index - 2;
		}

		return answer;
	}
}
