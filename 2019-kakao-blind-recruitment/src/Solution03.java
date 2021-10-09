import java.util.*;

class Solution03 {
	static ArrayList<HashSet<Integer>> candidateKeys; // �ּҼ�, ���ϼ��� ������ �����ϴ� �ĺ�Ű
	static String[][] table; // �Է¹��� ���̺� ����
	static int length; // �Ӽ��� ����

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

		/** length���� �Ӽ� �߿��� number���� ������ Ž�� */
		for (int i = 1; i <= length; i++)
			combination(arr, visited, 0, i);

		return answer;
	}

	/** ���̺��� �ĺ�Ű�� �� �� �ִ� ��� ������ Ž�� */
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
				/* �Ӽ��� ������ �ּҼ��� �������� �ʴ� ��� */
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

	/** �Ӽ��� ������ ���ϼ��� �����ϴ� �� Ȯ�� �ϴ� �޼��� */
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