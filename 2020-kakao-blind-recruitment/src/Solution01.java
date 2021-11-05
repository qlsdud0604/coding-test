import java.io.*;
import java.util.*;

class Solution01 {
	static int answer;

	public int solution(String s) {
		answer = s.length();

		for (int i = 1; i <= s.length() / 2; i++) {
			answer = Math.min(compression(s, i), answer);
		}

		return answer;
	}

	/** 주어진 문자열을 압축하는 메서드 */
	static int compression(String s, int n) {

		/* 나머지 문자열을 계산 */
		String remains = "";

		if (s.length() % n != 0)
			remains += s.substring(s.length() - s.length() % n, s.length());

		/* 문자열 압축 */
		String compressionString = s.substring(0, 0 + n);
		String temp = s.substring(0, 0 + n);

		int count = 1;

		for (int i = n; i < s.length() - s.length() % n; i += n) {
			String string = s.substring(i, i + n);

			if (string.equals(temp)) {
				count++;
			} else {
				if (count != 1)
					compressionString += count;

				compressionString += string;

				temp = string;

				count = 1;
			}
		}

		if (count != 1)
			compressionString += count;

		return compressionString.length() + remains.length();
	}
}