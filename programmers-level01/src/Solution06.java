import java.io.*;
import java.util.*;

public class Solution06 {

	public String solution(String[] participant, String[] completion) {

		Map<String, Integer> map = new HashMap<>();

		for (String string : participant) {

			if (map.containsKey(string))
				map.put(string, map.get(string) + 1);
			else
				map.put(string, 1);
		}

		for (String string : completion) {
			map.put(string, map.get(string) - 1);
		}

		String answer = "";

		for (String string : map.keySet()) {
			if (map.get(string) != 0)
				answer = string;
		}

		return answer;
	}
}
