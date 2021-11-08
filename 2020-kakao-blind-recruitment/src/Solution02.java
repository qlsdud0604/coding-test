import java.io.*;
import java.util.*;

class Solution02 {
	public String solution(String p) {

		/** 빈 문자열인 경우 */
		if (p.equals(""))
			return p;

		/** 올바른 괄호 문자열인 경우 */
		if (isCorrect(p)) {
			return p;
		}

		String result = changeCorrect(p);

		return result;
	}

	/** 올바른 괄호 문자열로 변환하는 메서드 */
	static String changeCorrect(String string) {

		if (string.equals(""))
			return "";

		String result = "";

		String[] stringArr = divide(string);

		String u = stringArr[0];
		String v = stringArr[1];

		/* u가 올바른 괄호 문자열인 경우 */
		if (isCorrect(u)) {
			result += u + changeCorrect(v);
		}
		/* u가 올바른 괄호 문자열이 아닌 경우 */
		else {
			String temp = "(";
			temp += changeCorrect(v);
			temp += ")";

			u = u.substring(1, u.length() - 1);

			u = change(u);

			temp += u;

			result += temp;
		}
		return result;
	}

	/** 괄호 방향을 뒤집는 메서드 */
	static String change(String string) {
		String result = "";

		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '(') {
				result += ")";
			} else {
				result += "(";
			}
		}

		return result;
	}

	/** 올바른 괄호 문자열인지 판별하는 메서드 */
	static boolean isCorrect(String string) {
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < string.length(); i++) {
			String input = string.charAt(i) + "";

			if (input.equals("(")) {
				stack.push(input);
			} else {
				if (!stack.isEmpty())
					stack.pop();
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

	/** 문자열을 분해하는 메서드 */
	static String[] divide(String string) {
		String u = ""; // 더 이상 분리할 수 없는, 균형잡힌 괄호 문자열
		String v = "";

		int left = 0;
		int right = 0;

		for (int i = 0; i < string.length(); i++) {
			String input = string.charAt(i) + "";

			if (input.equals("(")) {
				left++;
			} else {
				right++;
			}

			if (left == right) {
				u = string.substring(0, i + 1);
				v = string.substring(i + 1, string.length());
				break;
			}
		}

		return new String[] { u, v };
	}
}