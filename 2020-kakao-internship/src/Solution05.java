import java.io.*;
import java.util.*;

public class Solution05 {
	static int N;
	static ArrayList<Integer>[] graph;
	static boolean[] visited;

	static int[] before;
	static int[] after;

	static Stack<Integer> stack = new Stack<>();

	public boolean solution(int n, int[][] path, int[][] order) {
		N = n;
		graph = new ArrayList[N];
		visited = new boolean[N];

		before = new int[N];
		after = new int[N];

		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
		}

		/** �־��� ��� �����͸� ���� �׷��� ���� */
		for (int i = 0; i < path.length; i++) {
			int x = path[i][0];
			int y = path[i][1];

			graph[x].add(y);
			graph[y].add(x);
		}

		/** ���� �� ������ ���� */
		for (int i = 0; i < order.length; i++) {
			int x = order[i][0];
			int y = order[i][1];

			before[y] = x;
		}

		if (before[0] != 0)
			return false;

		visited[0] = true;

		for (int i = 0; i < graph[0].size(); i++) {
			stack.add(graph[0].get(i));
		}

		/** dfs Ž�� */
		while (!stack.isEmpty()) {
			int room = stack.pop();

			/* �湮�� ���� ��� */
			if (visited[room]) {
				continue;
			}

			/* ���� ���� �湮���� ���� ��� */
			if (!visited[before[room]]) {
				after[before[room]] = room;
				continue;
			}

			visited[room] = true;

			for (int i = 0; i < graph[room].size(); i++) {
				stack.add(graph[room].get(i));
			}
			stack.add(after[room]);
		}

		for (int i = 0; i < N; i++)
			if (!visited[i])
				return false;

		return true;
	}
}
