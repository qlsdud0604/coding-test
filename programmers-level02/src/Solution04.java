import java.io.*;
import java.util.*;

public class Solution04 {
	static String[] numbers;
	static boolean[] visited;
	static String[] arr;

	static Set<Integer> set = new HashSet<>();

	public int solution(String input) {

		numbers = input.split("");

		visited = new boolean[numbers.length];

		for (int i = 1; i <= numbers.length; i++) {
			arr = new String[i];

			dfs(0, i);
		}

		return set.size();
	}

	/** 모든 조합을 탐색하는 메서드 */
	static void dfs(int depth, int finish) {
		if (depth == finish) {

			String string = "";

			for (String number : arr)
				string += number;

			/* 조합한 수가 소수인 경우 set 자료구조에 삽입 */
			if (isPrime(Integer.parseInt(string)))
				set.add(Integer.parseInt(string));

			return;
		}

		for (int i = 0; i < numbers.length; i++) {
			if (visited[i] == false) {
				visited[i] = true;

				arr[depth] = numbers[i];
				dfs(depth + 1, finish);

				visited[i] = false;
			}
		}
	}

	/** 소수인지 판별하는 메서드 */
	static boolean isPrime(int number) {

		if (number == 0 || number == 1)
			return false;

		if (number == 2)
			return true;

		for (int i = 2; i <= number / 2 + 1; i++) {
			if (number % i == 0)
				return false;
		}

		return true;
	}
}
