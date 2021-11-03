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

	/** 경주로의 각 위치를 탐색 */
	static void dfs(int x, int y, int cost, int direction) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y, cost, direction));

		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Node node = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nextX = node.x + row[i];
				int nextY = node.y + col[i];

				/* 진입 가능한 경로인 경우 */
				if (check(nextX, nextY)) {
					int newCost = 0;

					/* 직선 경로인 경우 */
					if (node.direction == -1 || node.direction == i)
						newCost = node.cost + 100;

					/* 커브 경로인 경우 */
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

	/** 진입 가능한 경로인지 판별하는 메서드 */
	static boolean check(int x, int y) {

		if (x < 0 || N <= x || y < 0 || N <= y)
			return false;

		if (map[x][y] == 1)
			return false;

		return true;
	}

	/** 경주로의 각 위치를 정의한 클래스 */
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