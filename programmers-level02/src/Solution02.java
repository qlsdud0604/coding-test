import java.io.*;
import java.util.*;

public class Solution02 {

	public int[] solution(int[] progresses, int[] speeds) {

		int[] remains = new int[progresses.length];

		for (int i = 0; i < progresses.length; i++) {
			int target = 100 - progresses[i];

			if (target % speeds[i] == 0)
				remains[i] = target / speeds[i];
			else
				remains[i] = target / speeds[i] + 1;
		}

		List<Integer> list = new ArrayList<>();

		int count = 1;
		int current = remains[0];

		for (int i = 1; i < remains.length; i++) {
			if (current < remains[i]) {
				list.add(count);
				current = remains[i];
				count = 1;
			} else {
				count++;
			}
		}

		list.add(count);

		return list.stream().mapToInt(i -> i.intValue()).toArray();
	}
}