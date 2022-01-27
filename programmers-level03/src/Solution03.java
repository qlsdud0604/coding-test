import java.io.*;
import java.util.*;

public class Solution03 {
	static boolean[] visited; // 각 경로의 방문 여부를 저장하기 위한 배열

	static List<String> result = new ArrayList<>();

	public String[] solution(String[][] tickets) {

		visited = new boolean[tickets.length];

		dfs("ICN", "ICN", 0, tickets);

		Collections.sort(result);

		String[] answer = result.get(0).split(" ");

		return answer;
	}

	/** dfs 알고리즘을 이용해서 모든 여행경로들을 탐색 */
	static void dfs(String start, String route, int count, String[][] tickets) {

		if (count == tickets.length) {
			result.add(route);

			return;
		}

		for (int i = 0; i < tickets.length; i++) {

			/* 아직 방문하지 않은 여행경로인 경우 */
			if (visited[i] == false && tickets[i][0].equals(start)) {
				visited[i] = true;

				dfs(tickets[i][1], route + " " + tickets[i][1], count + 1, tickets);

				visited[i] = false;
			}
		}
	}
}