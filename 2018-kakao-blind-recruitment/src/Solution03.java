import java.util.*;

public class Solution03 {
	static ArrayList<String> list1 = new ArrayList<>();
	static ArrayList<String> list2 = new ArrayList<>();

	static ArrayList<String> inter = new ArrayList<>();
	static ArrayList<String> union = new ArrayList<>();

	public int solution(String str1, String str2) {

		/** �Է¹��� ���ڿ� �빮�ڷ� ��ȯ */
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		/** ������������ ��ȯ */
		for (int i = 0; i < str1.length() - 1; i++) {
			if ('A' <= str1.charAt(i) && str1.charAt(i) <= 'Z' && 'A' <= str1.charAt(i + 1)
					&& str1.charAt(i + 1) <= 'Z') {
				String input = str1.charAt(i) + "" + str1.charAt(i + 1);
				list1.add(input);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			if ('A' <= str2.charAt(i) && str2.charAt(i) <= 'Z' && 'A' <= str2.charAt(i + 1)
					&& str2.charAt(i + 1) <= 'Z') {
				String input = str2.charAt(i) + "" + str2.charAt(i + 1);
				list2.add(input);
			}
		}

		/** ���絵 ��� */
		function();

		if (union.size() == 0)
			return 65536;

		int answer = (int) ((float) inter.size() / (float) union.size() * 65536);

		return answer;
	}

	/** �� �������� ������ ������, �������� ���ϴ� �޼��� */
	static void function() {
		/** ������ ��� */
		for (String string : list1) {
			if (list2.remove(string)) {
				inter.add(string);
			}
			union.add(string);
		}

		/** ������ ��� */
		for (String string : list2) {
			union.add(string);
		}
	}
}
