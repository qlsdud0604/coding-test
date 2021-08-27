import java.util.*;

public class Solution03 {
	static ArrayList<String> list1 = new ArrayList<>();
	static ArrayList<String> list2 = new ArrayList<>();

	static ArrayList<String> inter = new ArrayList<>();
	static ArrayList<String> union = new ArrayList<>();

	public int solution(String str1, String str2) {

		/** 입력받은 문자열 대문자로 변환 */
		str1 = str1.toUpperCase();
		str2 = str2.toUpperCase();

		/** 다중집합으로 변환 */
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

		/** 유사도 계산 */
		function();

		if (union.size() == 0)
			return 65536;

		int answer = (int) ((float) inter.size() / (float) union.size() * 65536);

		return answer;
	}

	/** 두 다중집합 사이의 교집합, 합집합을 구하는 메서드 */
	static void function() {
		/** 교집합 계산 */
		for (String string : list1) {
			if (list2.remove(string)) {
				inter.add(string);
			}
			union.add(string);
		}

		/** 합집합 계산 */
		for (String string : list2) {
			union.add(string);
		}
	}
}
