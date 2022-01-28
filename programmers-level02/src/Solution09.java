import java.io.*;
import java.util.*;

class Solution09 {
	public int solution(int[] citations) {

		int answer = 0;

		Arrays.sort(citations); // 0, 1, 3, 5, 6

		for (int i = 0; i < citations.length; i++) {
			int h = citations.length - i; // 5, 4, 3, 2, 1

			if (h <= citations[i]) {
				answer = h;
				break;
			}
		}

		return answer;
	}
}