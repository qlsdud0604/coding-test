import java.io.*;
import java.util.*;

public class Solution03 {
	static boolean[] visited; // �� ����� �湮 ���θ� �����ϱ� ���� �迭

	static List<String> result = new ArrayList<>();

	public String[] solution(String[][] tickets) {

		visited = new boolean[tickets.length];

		dfs("ICN", "ICN", 0, tickets);

		Collections.sort(result);

		String[] answer = result.get(0).split(" ");

		return answer;
	}

	/** dfs �˰����� �̿��ؼ� ��� �����ε��� Ž�� */
	static void dfs(String start, String route, int count, String[][] tickets) {

		if (count == tickets.length) {
			result.add(route);

			return;
		}

		for (int i = 0; i < tickets.length; i++) {

			/* ���� �湮���� ���� �������� ��� */
			if (visited[i] == false && tickets[i][0].equals(start)) {
				visited[i] = true;

				dfs(tickets[i][1], route + " " + tickets[i][1], count + 1, tickets);

				visited[i] = false;
			}
		}
	}
}