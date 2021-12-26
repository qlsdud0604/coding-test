import java.io.*;
import java.util.*;

public class Solution04 {
	public int solution(int[] a, int[] b) {

		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			int aNumber = a[i];
			int bNumber = b[i];

			answer += aNumber * bNumber;
		}

		return answer;
	}
}
