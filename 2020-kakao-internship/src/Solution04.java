import java.io.*;
import java.util.*;

class Solution04 {
	static int N;
	static int[][] map;
	static boolean[][] visited;

	static int[] row = { -1, 0, 1, 0 };
	static int[] col = { 0, 1, 0, -1 };

	public int solution(int[][] board) {
		N = board.length;
		map = board;
		visited = new boolean[N][N];

		dfs(0, 0, 0, -1);

		return map[N - 1][N - 1];
	}

	/** ���ַ��� �� ��ġ�� Ž�� */
	static void dfs(int x, int y, int cost, int direction) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, cost, direction));

		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = node.x + row[i];
				int nextY = node.y + col[i];

				/* ���� ������ ����� ��� */
				if (check(nextX, nextY)) {
					int newCost = 0;

					/* ���� ����� ��� */
					if (node.direction == -1 || node.direction == i)
						newCost = node.cost + 100;

					/* Ŀ�� ����� ��� */
					else if (node.direction != i)
						newCost = node.cost + 600;

					if (visited[nextX][nextY] == false || newCost <= map[nextX][nextY]) {
						visited[nextX][nextY] = true;

						map[nextX][nextY] = newCost;
						queue.add(new Node(nextX, nextY, newCost, i));
					}
				}
			}
		}
	}

	/** ���� ������ ������� �Ǻ��ϴ� �޼��� */
	static boolean check(int x, int y) {

		if (x < 0 || N <= x || y < 0 || N <= y)
			return false;

		if (map[x][y] == 1)
			return false;

		return true;
	}

	/** ���ַ��� �� ��ġ�� ������ Ŭ���� */
	static class Node {
		int x;
		int y;
		int cost;
		int direction;

		Node(int x, int y, int cost, int direction) {
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.direction = direction;
		}
	}
}