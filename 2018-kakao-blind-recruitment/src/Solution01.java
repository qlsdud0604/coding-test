import java.util.*;

class Solution01 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String string = Integer.toBinaryString(arr1[i] | arr2[i]);
			string = String.format("%" + n + "s", string);

			string = string.replace("1", "#");
			string = string.replace("0", " ");

			answer[i] = string;
		}

		return answer;
	}
}