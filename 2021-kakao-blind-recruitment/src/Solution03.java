import java.io.*;
import java.util.*;

public class Solution03 {
	static Map<String, ArrayList<Integer>> map = new HashMap<>();
	static ArrayList<Integer> list;

	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		/** info의 모든 조합을 탐색 */
		for (int i = 0; i < info.length; i++) {
			String[] record = info[i].split(" ");
			dfs("", 0, record);
		}

		/** map 정렬 */
		for (String string : map.keySet())
			Collections.sort(map.get(string));

		/** 이진 탐색 */
		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] input = query[i].split(" ");

			int score = Integer.parseInt(input[1]);

			answer[i] = search(input[0], score);
		}

		return answer;
	}

	/** info로 구성할 수 있는 모든 조합을 탐색 */
	static void dfs(String string, int depth, String[] record) {
		if (depth == 4) {

			/* map에 해당 조합이 없는 경우 */
			if (!map.containsKey(string)) {
				list = new ArrayList<>();
				list.add(Integer.parseInt(record[4]));

				map.put(string, list);
			}
			/* map에 해당 조합이 있는 경우 */
			else {
				map.get(string).add(Integer.parseInt(record[4]));
			}
			return;
		}

		dfs(string + "-", depth + 1, record);
		dfs(string + record[depth], depth + 1, record);
	}

	/** 이진 탐색 */
	static int search(String string, int score) {

		if (!map.containsKey(string))
			return 0;

		ArrayList<Integer> list = map.get(string);

		int answer = 0;

		int start = 0;
		int end = list.size() - 1;

		while (start <= end) {
			int middle = (start + end) / 2;

			if (list.get(middle) < score)
				start = middle + 1;
			else
				end = middle - 1;
		}

		return list.size() - start;
	}
}