import java.util.*;

public class Solution02 {
	static int[] answer;
	static int[] number = new int[100000 + 1];

	static ArrayList<Element> list = new ArrayList<>();

	public int[] solution(String s) {
		String[] input = s.split("\\{|\\}|\\,");

		/** 주어진 문자열 탐색 */
		for (int i = 0; i < input.length; i++) {
			if (!input[i].equals("")) {
				int index = Integer.parseInt(input[i]);
				number[index]++;
			}
		}

		/** 원소 탐색 */
		for (int i = 0; i < number.length; i++) {
			if (number[i] != 0) {
				list.add(new Element(i, number[i]));
			}
		}

		Collections.sort(list);

		answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i).number;

		return answer;
	}

	/** 원소에 대한 정보를 정의 */
	static class Element implements Comparable<Element> {
		int number; // 원소 번호
		int count; // 원소의 빈도수

		Element(int number, int count) {
			this.number = number;
			this.count = count;
		}

		@Override
		public int compareTo(Element o) {
			return o.count - this.count;
		}
	}
}
