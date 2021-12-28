import java.io.*;
import java.util.*;

public class Solution08 {

	public int[] solution(int[] answers) {
		int[] person01 = { 1, 2, 3, 4, 5 };
		int[] person02 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] person03 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int[] point = new int[3];

		for (int i = 0; i < answers.length; i++) {
			if (person01[i % person01.length] == answers[i])
				point[0]++;
			if (person02[i % person02.length] == answers[i])
				point[1]++;
			if (person03[i % person03.length] == answers[i])
				point[2]++;
		}

		int max = Math.max(Math.max(point[0], point[1]), point[2]);

		List<Integer> list = new ArrayList<>();

		if (max == point[0])
			list.add(1);
		if (max == point[1])
			list.add(2);
		if (max == point[2])
			list.add(3);

		int[] answer = new int[list.size()];

		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);

		return answer;
	}
}
