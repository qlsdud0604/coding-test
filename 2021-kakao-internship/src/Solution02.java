import java.util.*;

class Solution02 {
	static String[][] arr; // 각 대기실에 대한 배열
	static boolean[][] visited; // 각 대기실 자리에 대한 방문 여부를 저장하는 배열

	static int[] row = { -1, 0, 1, 0 };
	static int[] col = { 0, 1, 0, -1 };

	public int[] solution(String[][] places) {
		int[] answer = new int[5];

		for (int i = 0; i < 5; i++) {
			answer[i] = isCorrect(places[i]);
		}

		return answer;
	}

	static int isCorrect(String[] place) {

		arr = new String[5][5];
		visited = new boolean[5][5];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				arr[i][j] = place[i].charAt(j) + "";
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {

				if (place[i].charAt(j) == 'P')
					if (!bfs(i, j))
						return 0;
			}
		}

		return 1;
	}

	/** bfs 탐색 */
	static boolean bfs(int x, int y) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add(new Node(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nodeX = node.x + row[i];
				int nodeY = node.y + col[i];
				int manhattan = Math.abs(x - nodeX) + Math.abs(y - nodeY);

				if (!check(nodeX, nodeY) || 2 < manhattan)
					continue;

				if (arr[nodeX][nodeY].equals("P"))
					return false;
				
				
				visited[nodeX][nodeY] = true;
				queue.add(new Node(nodeX, nodeY));
			}
		}

		return true;
	}

	/** 진입 가능 여부 확인 */
	static boolean check(int x, int y) {

		/* 범위를 넘어간 경우 진입 불가 */
		if (x < 0 || 5 <= x || y < 0 || 5 <= y)
			return false;

		/* 방문한 곳이거나 파티션으로 막혀있는 경우 진입 불가 */
		if (visited[x][y] == true || arr[x][y].equals("X"))
			return false;

		return true;
	}

	/** 노드에 대한 정보 */
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}