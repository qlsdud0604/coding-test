import java.util.*;

class Solution01 {
	static int[][] map;
	static ArrayList<Integer> basket = new ArrayList<>();
	static int answer = 0;

	public int solution(int[][] board, int[] moves) {
		map = board;

		for (int i = 0; i < moves.length; i++) {
			int doll = getDoll(moves[i]);

			if (doll != 0)
				answer += putBasket(doll);
		}

		return answer;
	}

	/** n��° ��ġ���� ������ ������ �޼��� */
	static int getDoll(int n) {
		int doll = 0;

		/* n��° ��ġ�� ������ ���� Ž�� */
		for (int i = 0; i < map.length; i++) {
			/* ������ ��� */
			if (map[i][n - 1] != 0) {
				doll = map[i][n - 1];
				map[i][n - 1] = 0;
				break;
			}
		}

		return doll;
	}

	/** �ٱ��Ͽ� ������ ��� �޼��� */
	static int putBasket(int doll) {
		int result = 0;

		/* �ٱ��ϰ� ����ְų� �ٱ��� �� ���� ������ ���� ������ �ƴ� ��� */
		if (basket.isEmpty() || basket.get(basket.size() - 1) != doll)
			basket.add(doll);
		/* �ٱ����� �� ���� ������ ���� ������ ��� */
		else {
			result++;

			for (int i = basket.size() - 1; i >= 0; i--) {
				if (basket.get(i) == doll) {
					result++;
					basket.remove(i);
				} else
					break;
			}
		}

		return result;
	}
}