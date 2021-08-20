import java.util.*;

class Solution02 {
	static String[][] arr; // �� ���ǿ� ���� �迭
	static boolean[][] visited; // �� ���� �ڸ��� ���� �湮 ���θ� �����ϴ� �迭

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

	/** bfs Ž�� */
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

	/** ���� ���� ���� Ȯ�� */
	static boolean check(int x, int y) {

		/* ������ �Ѿ ��� ���� �Ұ� */
		if (x < 0 || 5 <= x || y < 0 || 5 <= y)
			return false;

		/* �湮�� ���̰ų� ��Ƽ������ �����ִ� ��� ���� �Ұ� */
		if (visited[x][y] == true || arr[x][y].equals("X"))
			return false;

		return true;
	}

	/** ��忡 ���� ���� */
	static class Node {
		int x;
		int y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}