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

	/** 1. 신규 아이디의 모든 대문자를 소문자로 치환 */
	static void step01() {
		newId = newId.toLowerCase();
	}

	/** 2. 소문자, 숫자, 빼기, 밑줄, 마침표를 제외한 모든 문자 제거 */
	static void step02() {
		String temp = "";

		for (int i = 0; i < newId.length(); i++) {
			char ch = newId.charAt(i);

			if (('a' <= ch && ch <= 'z') || ('0' <= ch && ch <= '9') || ch == '-' || ch == '_' || ch == '.')
				temp += ch;

		}

		newId = temp;
	}

	/** 3. 마침표가 2번 이상 연속된 부분을 하나의 마침표로 치환 */
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

	/** 4. 마침표가 처음이나 끝에 위치한다면 제거 */
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

	/** 5. 빈 문자열은 "a"를 대입 */
	static void step05() {
		if (newId.equals(""))
			newId = "a";
	}

	/** 6. 길이가 16자 이상이면 첫 15개의 문자를 제외한 나머지 문자 제거 */
	static void step06() {

		if (16 <= newId.length())
			newId = newId.substring(0, 15);

		step04();
	}

	/** 7. 길이가 2자 이하라면, 마지막 문자를 길이가 3이 될 때까지 반복해서 추가 */
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
