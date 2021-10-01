import java.util.*;

public class Solution02 {
	static int[] answer;
	static int[] number = new int[100000 + 1];

	static ArrayList<Element> list = new ArrayList<>();

	public int[] solution(String s) {
		String[] input = s.split("\\{|\\}|\\,");

		/** �־��� ���ڿ� Ž�� */
		for (int i = 0; i < input.length; i++) {
			if (!input[i].equals("")) {
				int index = Integer.parseInt(input[i]);
				number[index]++;
			}
		}

		/** ���� Ž�� */
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

	/** ���ҿ� ���� ������ ���� */
	static class Element implements Comparable<Element> {
		int number; // ���� ��ȣ
		int count; // ������ �󵵼�

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
