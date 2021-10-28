import java.io.*;
import java.util.*;

class Solution02 {
	static ArrayList<Long> numberList = new ArrayList<>();
	static ArrayList<String> operatorList = new ArrayList<>();

	static String[] operators = { "+", "-", "*" };
	static String[] priority = new String[3];
	static boolean[] visited = new boolean[3];

	static long answer = Long.MIN_VALUE;

	public long solution(String expression) {

		String string = "";

		for (int i = 0; i < expression.length(); i++) {
			char ch = expression.charAt(i);

			if (ch == '+' || ch == '-' || ch == '*') {
				operatorList.add(ch + "");
				numberList.add(Long.parseLong(string));
				string = "";
			} else {
				string += ch;
			}
		}

		numberList.add(Long.parseLong(string));

		dfs(0);

		return answer;
	}

	/** 연산자의 우선순위 조합을 탐색 */
	static void dfs(int depth) {
		if (depth == 3) {
			solve();
			return;
		}

		for (int i = 0; i < 3; i++) {
			if (visited[i] == false) {
				visited[i] = true;

				priority[depth] = operators[i];
				dfs(depth + 1);

				visited[i] = false;
			}
		}
	}

	/** 연산자의 우선순위를 이용하여 계산하는 메서드 */
	static void solve() {
		ArrayList<Long> numberCopy = new ArrayList<>();
		numberCopy.addAll(numberList);

		ArrayList<String> operatorCopy = new ArrayList<>();
		operatorCopy.addAll(operatorList);

		for (int i = 0; i < 3; i++) {
			String operator = priority[i];

			for (int j = 0; j < operatorCopy.size(); j++) {
				if (operatorCopy.get(j).equals(operator)) {
					long result = calculate(operator, numberCopy.get(j), numberCopy.get(j + 1));

					operatorCopy.remove(j);
					numberCopy.remove(j + 1);
					numberCopy.remove(j);

					numberCopy.add(j, result);

					j--;
				}
			}
		}

		answer = Math.max(answer, Math.abs(numberCopy.get(0)));
	}

	/** 두 개의 피연산자를 계산하는 메서드 */
	static Long calculate(String operator, Long number01, Long number02) {
		if (operator.equals("+"))
			return number01 + number02;
		else if (operator.equals("-"))
			return number01 - number02;
		else
			return number01 * number02;
	}
}