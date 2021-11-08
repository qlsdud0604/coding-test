import java.io.*;
import java.util.*;

class Solution02 {
	public String solution(String p) {

		/** �� ���ڿ��� ��� */
		if (p.equals(""))
			return p;

		/** �ùٸ� ��ȣ ���ڿ��� ��� */
		if (isCorrect(p)) {
			return p;
		}

		String result = changeCorrect(p);

		return result;
	}

	/** �ùٸ� ��ȣ ���ڿ��� ��ȯ�ϴ� �޼��� */
	static String changeCorrect(String string) {

		if (string.equals(""))
			return "";

		String result = "";

		String[] stringArr = divide(string);

		String u = stringArr[0];
		String v = stringArr[1];

		/* u�� �ùٸ� ��ȣ ���ڿ��� ��� */
		if (isCorrect(u)) {
			result += u + changeCorrect(v);
		}
		/* u�� �ùٸ� ��ȣ ���ڿ��� �ƴ� ��� */
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

	/** ��ȣ ������ ������ �޼��� */
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

	/** �ùٸ� ��ȣ ���ڿ����� �Ǻ��ϴ� �޼��� */
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

	/** ���ڿ��� �����ϴ� �޼��� */
	static String[] divide(String string) {
		String u = ""; // �� �̻� �и��� �� ����, �������� ��ȣ ���ڿ�
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