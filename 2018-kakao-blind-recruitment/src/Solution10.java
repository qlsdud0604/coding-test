import java.text.SimpleDateFormat;
import java.util.*;

public class Solution10 {
	static int[] count;

	public int solution(String[] lines) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
		count = new int[lines.length];

		int answer = 0;

		for (int i = 0; i < lines.length; i++) {
			/* 이전 로그의 종료 시간 */
			String[] pre = lines[i].split(" ");
			Date preEndDate = format.parse(pre[1]);
			long preEndTime = preEndDate.getTime();

			/* 다음 로그들의 시작 시간 */
			for (int j = i; j < lines.length; j++) {
				String[] post = lines[j].split(" ");
				Date postEndDate = format.parse(post[1]);
				long postEndTime = postEndDate.getTime();

				double time = Double.parseDouble(post[2].substring(0, post[2].length() - 1));

				long postStartTime = (long) (postEndTime - (time * 1000) + 1);

				if (postStartTime - preEndTime <= 999) {
					count[i]++;
					answer = Math.max(answer, count[i]);
				}

			}
		}
		return answer;
	}
}
