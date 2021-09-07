import java.text.SimpleDateFormat;
import java.util.*;

public class Solution11 {
	static PriorityQueue<Integer> queue = new PriorityQueue<>();
	static ArrayList<Integer>[] bus;

	public String solution(int n, int t, int m, String[] timetable) throws Exception {

		bus = new ArrayList[n];

		/* ũ���� ���� �ð� ������ �켱���� ť�� ���� */
		for (int i = 0; i < timetable.length; i++) {
			String[] input = timetable[i].split(":");

			int hour = Integer.parseInt(input[0]) * 60;
			int minute = Integer.parseInt(input[1]);

			queue.add(hour + minute);
		}

		int startTime = 9 * 60;

		int answer = 0;

		/* ������ ���� Ƚ����ŭ �ݺ� */
		for (int i = 0; i < n; i++) {
			bus[i] = new ArrayList<>();

			while (!queue.isEmpty()) {
				int arrivalTime = queue.poll();

				/** ���� ũ���� �����ð��� ������ �ð����� �۰�, ������ �ڸ��� ���� ��� */
				if (arrivalTime <= startTime && bus[i].size() < m) {
					bus[i].add(arrivalTime);
					answer = arrivalTime - 1;
				}
				/** �׷��� ���� ��� �ٽ� �켱���� ť�� ũ���� ���� ���� */
				else {
					queue.add(arrivalTime);
					break;
				}
			}
			startTime += t;
		}

		/* ������ ������ �ڸ��� ���� ��� ���� �����ð��� ���缭 ��⿭�� ���� */
		if (bus[n - 1].size() < m)
			answer = startTime - t;

		String hour = String.format("%02d", answer / 60);
		String minute = String.format("%02d", answer % 60);

		return hour + ":" + minute;
	}
}
