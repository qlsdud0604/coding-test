import java.io.*;
import java.util.*;

public class Solution07 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };

		System.out.println(solution(array, commands));
	}

	static public int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			int[] command = commands[i];

			int x = command[0] - 1; // x번째 숫자부터
			int y = command[1] - 1; // y번째 숫자까지
			int z = command[2] - 1; // 정렬했을 때 z번째에 있는 수

			int[] temp = new int[y - x + 1];

			for (int j = x; j <= y; j++) {
				temp[j - x] = array[j];
			}

			Arrays.sort(temp);

			answer[i] = temp[z];
		}
		
		return answer;
	}
}
