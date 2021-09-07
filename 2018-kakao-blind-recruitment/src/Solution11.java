import java.text.SimpleDateFormat;
import java.util.*;

public class Solution11 {
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	static ArrayList<Integer>[] bus;

	public String solution(int n, int t, int m, String[] timetable) throws Exception {

		bus = new ArrayList[n];

		/* 크루의 도착 시간 정보를 우선순위 큐에 삽입 */
		for (int i = 0; i < timetable.length; i++) {
			String[] input = timetable[i].split(":");

			int hour = Integer.parseInt(input[0]) * 60;
			int minute = Integer.parseInt(input[1]);

			queue.add(hour + minute);
		}

		int startTime = 9 * 60;

		int answer = 0;

		/* 버스의 운행 횟수만큼 반복 */
		for (int i = 0; i < n; i++) {
			bus[i] = new ArrayList<>();

			while (!queue.isEmpty()) {
				int arrivalTime = queue.poll();

				/** 현재 크루의 도착시간이 버스의 시간보다 작고, 버스의 자리가 남는 경우 */
				if (arrivalTime <= startTime && bus[i].size() < m) {
					bus[i].add(arrivalTime);
					answer = arrivalTime - 1;
				}
				/** 그렇지 않은 경우 다시 우선순위 큐에 크루의 정보 삽입 */
				else {
					queue.add(arrivalTime);
					break;
				}
			}
			startTime += t;
		}

		/* 마지막 버스의 자리가 남은 경우 버스 도착시간에 맞춰서 대기열에 도착 */
		if (bus[n - 1].size() < m)
			answer = startTime - t;

		String hour = String.format("%02d", answer / 60);
		String minute = String.format("%02d", answer % 60);

		return hour + ":" + minute;
	}
}
