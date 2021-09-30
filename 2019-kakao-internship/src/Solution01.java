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

	/** n번째 위치에서 인형을 꺼내는 메서드 */
	static int getDoll(int n) {
		int doll = 0;

		/* n번째 위치의 위에서 부터 탐색 */
		for (int i = 0; i < map.length; i++) {
			/* 인형인 경우 */
			if (map[i][n - 1] != 0) {
				doll = map[i][n - 1];
				map[i][n - 1] = 0;
				break;
			}
		}

		return doll;
	}

	/** 바구니에 인형을 담는 메서드 */
	static int putBasket(int doll) {
		int result = 0;

		/* 바구니가 비어있거나 바구니 맨 위의 인형이 같은 인형이 아닌 경우 */
		if (basket.isEmpty() || basket.get(basket.size() - 1) != doll)
			basket.add(doll);
		/* 바구니의 맨 위의 인형이 같은 인형인 경우 */
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