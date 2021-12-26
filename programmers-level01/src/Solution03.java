import java.io.*;
import java.util.*;

public class Solution03 {
	public int solution(int[] numbers) {
		boolean[] checked = new boolean[10];

		Arrays.fill(checked, false);

		for (int i = 0; i < numbers.length; i++) {
			int number = numbers[i];

			checked[number] = true;
		}

		int answer = 0;

		for (int i = 0; i < 10; i++) {
			if (checked[i] == false)
				answer += i;
		}

		return answer;
	}

}