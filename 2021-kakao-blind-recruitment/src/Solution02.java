import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class Solution02 {
	static ArrayList<String> list = new ArrayList<>();
	static Map<String, Integer> map;

	static char[] alphabet;
	static boolean[] visited;

	static char[] arr;

	public ArrayList<String> solution(String[] orders, int[] course) {

		for (int i = 0; i < course.length; i++) {
			map = new HashMap<>();

			for (int j = 0; j < orders.length; j++) {

				alphabet = orders[j].toCharArray();
				Arrays.sort(alphabet);

				visited = new boolean[alphabet.length];
				arr = new char[course[i]];

				dfs(0, 0, course[i]);
			}

			int max = 0;

			for (Entry<String, Integer> entry : map.entrySet())
				max = Math.max(max, entry.getValue());

			for (Entry<String, Integer> entry : map.entrySet())
				if (2 <= max && entry.getValue() == max)
					list.add(entry.getKey());
		}

		Collections.sort(list);

		return list;
	}

	/** orders의 조합 만들기 */
	static void dfs(int start, int depth, int course) {
		if (depth == course) {
			String string = "";

			for (char alphabet : arr)
				string += alphabet;

			if (map.containsKey(string)) {
				map.put(string, map.get(string) + 1);
			} else {
				map.put(string, 1);
			}

			return;
		}

		for (int i = start; i < alphabet.length; i++) {
			if (visited[i] == false) {
				visited[i] = true;

				arr[depth] = alphabet[i];
				dfs(i, depth + 1, course);

				visited[i] = false;
			}
		}
	}
}