import java.util.*;

class Solution07 {
	static int[][] map;
	static int n;

	public int solution(int[][] board) {

		map = board;
		n = board.length;

		int answer = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int number = map[i][j];

				if (number == 0)
					continue;

				/** ����� A�� ��� */
				if (isA(number, i, j)) {
					if (dropBlackBlock(i, j + 1) && dropBlackBlock(i, j + 2)) {
						deleteBlock(i, j, i + 1, j, i + 1, j + 1, i + 1, j + 2);
						j = -1;
						answer++;
					}
				}

				/** ����� B�� ��� */
				else if (isB(number, i, j)) {
					if (dropBlackBlock(i + 1, j - 1)) {
						deleteBlock(i, j, i + 1, j, i + 2, j, i + 2, j - 1);
						j = -1;
						answer++;
					}
				}

				/** ����� C�� ��� */
				else if (isC(number, i, j)) {
					if (dropBlackBlock(i + 1, j + 1)) {
						deleteBlock(i, j, i + 1, j, i + 2, j, i + 2, j + 1);
						j = -1;
						answer++;
					}
				}

				/** ����� D�� ��� */
				else if (isD(number, i, j)) {
					if (dropBlackBlock(i, j - 1) && dropBlackBlock(i, j - 2)) {
						deleteBlock(i, j, i + 1, j, i + 1, j - 1, i + 1, j - 2);
						j = -1;
						answer++;
					}
				}

				/** ����� E�� ��� */
				else if (isE(number, i, j)) {
					if (dropBlackBlock(i, j - 1) && dropBlackBlock(i, j + 1)) {
						deleteBlock(i, j, i + 1, j, i + 1, j - 1, i + 1, j + 1);
						j = -1;
						answer++;
					}
				}
			}
		}

		return answer;
	}

	/** ���簢�� ������� ���� ����� ����߸� �� �ִ� ��� */
	static boolean dropBlackBlock(int x, int y) {
		for (int i = 0; i <= x; i++) {
			if (map[i][y] != 0)
				return false;
		}
		return true;
	}

	/** ����� ���ִ� �޼��� */
	static void deleteBlock(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
		map[x1][y1] = 0;
		map[x2][y2] = 0;
		map[x3][y3] = 0;
		map[x4][y4] = 0;
	}

	/** ��� A�� �Ǻ��ϴ� �޼��� */
	static boolean isA(int number, int x, int y) {
		if (n <= x + 1 || n <= y + 2)
			return false;

		return map[x + 1][y] == number && map[x + 1][y + 1] == number && map[x + 1][y + 2] == number;
	}

	/** ��� B�� �Ǻ��ϴ� �޼��� */
	static boolean isB(int number, int x, int y) {
		if (n <= x + 2 || y - 1 < 0)
			return false;

		return map[x + 1][y] == number && map[x + 2][y] == number && map[x + 2][y - 1] == number;
	}

	/** ��� C�� �Ǻ��ϴ� �޼��� */
	static boolean isC(int number, int x, int y) {
		if (n <= x + 2 || n <= y + 1)
			return false;

		return map[x + 1][y] == number && map[x + 2][y] == number && map[x + 2][y + 1] == number;
	}

	/** ��� D�� �Ǻ��ϴ� �޼��� */
	static boolean isD(int number, int x, int y) {
		if (n <= x + 1 || y - 2 < 0)
			return false;

		return map[x + 1][y] == number && map[x + 1][y - 1] == number && map[x + 1][y - 2] == number;
	}

	/** ��� E�� �Ǻ��ϴ� �޼��� */
	static boolean isE(int number, int x, int y) {
		if (n <= x + 1 || y - 1 < 0 || n <= y + 1)
			return false;

		return map[x + 1][y] == number && map[x + 1][y - 1] == number && map[x + 1][y + 1] == number;
	}
}