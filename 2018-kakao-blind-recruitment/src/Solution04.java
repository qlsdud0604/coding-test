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
			int count = checkMap(m, n); // 현재 판에 몇개의 2x2 블록이 있는지 검사

			if (count == 0) // 현재 판에 2x2 블록이 더 이상 없을 경우 종료
				break;

			answer += count;

			dropMap(m, n); // 현재 판의 2x2 블록을 삭제 후 기존의 블록 아래로 이동

		}

		return answer;
	}

	/** 현재 판에 몇 개의 2x2 블록이 있는지 검사 */
	static int checkMap(int m, int n) {
		int result = 0;
		checked = new boolean[m][n];

		for (int i = 0; i < m - 1; i++) {
			for (int j = 0; j < n - 1; j++) {
				/* 이미 지워진 블록을 탐색하는 경우에는 통과 */
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

	/** 해당 블록이 2x2 블록인지 검사 */
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

	/** 현재 판의 2x2 블록을 삭제하고 기존의 블록들 이동 */
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