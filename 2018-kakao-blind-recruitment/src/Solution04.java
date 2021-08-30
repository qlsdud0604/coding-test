import java.util.*;

class Solution04 {
	static char[][] map;
	static boolean[][] checked;

	public int solution(int m, int n, String[] board) {
		map = new char[m][n];

		for (int i = 0; i < m; i++) {
			map[i] = board[i].toCharArray();
		}

		int answer = 0;

		while (true) {
			int count = checkMap(m, n); // ���� �ǿ� ��� 2x2 ����� �ִ��� �˻�

			if (count == 0) // ���� �ǿ� 2x2 ����� �� �̻� ���� ��� ����
				break;

			answer += count;

			dropMap(m, n); // ���� ���� 2x2 ����� ���� �� ������ ��� �Ʒ��� �̵�

		}

		return answer;
	}

	/** ���� �ǿ� �� ���� 2x2 ����� �ִ��� �˻� */
	static int checkMap(int m, int n) {
		int result = 0;
		checked = new boolean[m][n];

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				/* �̹� ������ ����� Ž���ϴ� ��쿡�� ��� */
				if (map[i][j] == '.')
					continue;

				checkBlock(i, j, checked);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (checked[i][j]) {
					result++;
					map[i][j] = '.';
				}
			}
		}

		return result;
	}

	/** �ش� ����� 2x2 ������� �˻� */
	static void checkBlock(int i, int j, boolean[][] checked) {
		char block = map[i][j];

		for (int row = i; row < i + 2; row++) {
			for (int col = j; col < j + 2; col++) {
				if (map[row][col] != block)
					return;
			}
		}

		for (int row = i; row < i + 2; row++) {
			for (int col = j; col < j + 2; col++) {
				checked[row][col] = true;
			}
		}
	}

	/** ���� ���� 2x2 ����� �����ϰ� ������ ��ϵ� �̵� */
	static void dropMap(int m, int n) {
		for (int i = m - 1; i > 0; i--) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == '.') {
					for (int k = i - 1; k >= 0; k--) {
						if (map[k][j] != '.') {
							map[i][j] = map[k][j];
							map[k][j] = '.';
							break;
						}
					}
				}
			}
		}
	}
}