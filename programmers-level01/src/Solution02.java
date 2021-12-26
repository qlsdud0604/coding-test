import java.io.*;
import java.util.*;

public class Solution02 {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;

		for (int i = 0; i < absolutes.length; i++) {
			int absolute = absolutes[i];

			if (signs[i] == false)
				absolute *= -1;

			answer += absolute;
		}

		return answer;
	}
}