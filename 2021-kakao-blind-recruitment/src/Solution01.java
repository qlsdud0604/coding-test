import java.io.*;
import java.util.*;

public class Solution01 {
	static String newId;

	public static void main(String[] args) {
		String new_id = "=.=";
		System.out.println(solution(new_id));
	}

	static public String solution(String new_id) {
		newId = new_id;

		step01();
		step02();
		step03();
		step04();
		step05();
		step06();
		step07();

		return newId;
	}

	/** 1. �ű� ���̵��� ��� �빮�ڸ� �ҹ��ڷ� ġȯ */
	static void step01() {
		newId = newId.toLowerCase();
	}

	/** 2. �ҹ���, ����, ����, ����, ��ħǥ�� ������ ��� ���� ���� */
	static void step02() {
		String temp = "";

		for (int i = 0; i < newId.length(); i++) {
			char ch = newId.charAt(i);

			if (('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9') || ch == '-' || ch == '_' || ch == '.')
				temp += ch;

		}

		newId = temp;
	}

	/** 3. ��ħǥ�� 2�� �̻� ���ӵ� �κ��� �ϳ��� ��ħǥ�� ġȯ */
	static void step03() {
		String temp = newId.charAt(0) + "";

		for (int i = 1; i < newId.length(); i++) {
			char ch = newId.charAt(i);

			if (temp.charAt(temp.length() - 1) == '.' && ch == '.')
				continue;
			else
				temp += ch;
		}

		newId = temp;
	}

	/** 4. ��ħǥ�� ó���̳� ���� ��ġ�Ѵٸ� ���� */
	static void step04() {
		if (newId.equals(".") || newId.equals("..")) {
			newId = "";
		} else {
			if (newId.charAt(0) == '.')
				newId = newId.substring(1);

			if (newId.charAt(newId.length() - 1) == '.')
				newId = newId.substring(0, newId.length() - 1);
		}
	}

	/** 5. �� ���ڿ��� "a"�� ���� */
	static void step05() {
		if (newId.equals(""))
			newId = "a";
	}

	/** 6. ���̰� 16�� �̻��̸� ù 15���� ���ڸ� ������ ������ ���� ���� */
	static void step06() {

		if (16 <= newId.length())
			newId = newId.substring(0, 15);

		step04();
	}

	/** 7. ���̰� 2�� ���϶��, ������ ���ڸ� ���̰� 3�� �� ������ �ݺ��ؼ� �߰� */
	static void step07() {
		char ch = newId.charAt(newId.length() - 1);

		String temp = newId;

		if (newId.length() <= 2) {

			for (int i = 0; i < 3 - newId.length(); i++) {
				temp += ch;
			}
		}

		newId = temp;
	}
}
