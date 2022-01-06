import java.io.*;
import java.util.*;

public class Solution06 {

	static Map<String, Integer> map = new HashMap<>();

	public int solution(String[][] clothes) {

		for (int i = 0; i < clothes.length; i++) {
			String kind = clothes[i][1]; // �ǻ� ����

			if (!map.containsKey(kind)) {
				map.put(kind, 1);
			} else {
				map.put(kind, map.get(kind) + 1);
			}
		}

		int answer = 1;

		for (String kind : map.keySet())
			answer *= map.get(kind) + 1;

		return answer - 1; // �ƹ� �͵� ���� ���� ��� ����
	}

}
