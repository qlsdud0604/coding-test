import java.util.*;

class Solution03 {
	static ArrayList<HashSet<Integer>> candidateKeys; // 최소성, 유일성의 조건을 만족하는 후보키
	static String[][] table; // 입력받은 테이블 정보
	static int length; // 속성의 개수

	static int[] arr;
	static boolean[] visited;

	static int answer;

	public int solution(String[][] relation) {
		candidateKeys = new ArrayList<HashSet<Integer>>();
		table = relation;
		length = relation[0].length;

		arr = new int[length];
		visited = new boolean[length];

		for (int i = 0; i < length; i++)
			arr[i] = i;

		answer = 0;

		/** length개의 속성 중에서 number개의 조합을 탐색 */
		for (int i = 1; i <= length; i++)
			combination(arr, visited, 0, i);

		return answer;
	}

	/** 테이블에서 후보키가 될 수 있는 모든 조합을 탐색 */
	static void combination(int[] arr, boolean[] visited, int start, int number) {
		if (number == 0) {
			HashSet<Integer> set = new HashSet<Integer>();

			for (int i = 0; i < length; i++) {
				if (visited[i]) {
					set.add(arr[i]);
				}
			}

			if (!isUnique(set))
				return;

			for (HashSet<Integer> key : candidateKeys) {
				/* 속성의 조합이 최소성을 만족하지 않는 경우 */
				if (set.containsAll(key))
					return;
			}
			candidateKeys.add(set);
			answer++;
		}

		for (int i = start; i < length; i++) {
			visited[i] = true;
			combination(arr, visited, i + 1, number - 1);
			visited[i] = false;
		}
	}

	/** 속성의 조합이 유일성을 만족하는 지 확인 하는 메서드 */
	static boolean isUnique(HashSet<Integer> set) {
		ArrayList<String> list = new ArrayList<>();

		for (int i = 0; i < table.length; i++) {
			String temp = "";

			for (int index : set) {
				temp += table[i][index];
			}

			if (!list.contains(temp))
				list.add(temp);
			else
				return false;
		}
		return true;
	}

}