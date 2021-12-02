import java.io.*;
import java.util.*;

public class Solution05 {
	static int playTime;
	static int advTime;

	static int[] count;

	public String solution(String play_time, String adv_time, String[] logs) {
		playTime = toSecond(play_time);
		advTime = toSecond(adv_time);

		count = new int[playTime];

		for (int i = 0; i < logs.length; i++) {
			String[] log = logs[i].split("-");

			int startTime = toSecond(log[0]);
			int endTime = toSecond(log[1]);

			for (int j = startTime; j < endTime; j++)
				count[j]++;
		}

		long current = 0;

		for (int i = 0; i < advTime; i++)
			current += count[i];

		long max = current;
		long index = 0;

		for (int i = advTime; i < playTime; i++) {
			current = current + count[i] - count[i - advTime];

			if (max < current) {
				max = current;
				index = i - advTime + 1;
			}
		}

		return String.format("%02d:%02d:%02d", index / 3600, (index % 3600) / 60, (index % 3600) % 60);
	}

	/** 주어진 시간을 초 단위로 변경하는 메서드 */
	static int toSecond(String time) {
		String[] arr = time.split(":");

		return Integer.parseInt(arr[0]) * 3600 + Integer.parseInt(arr[1]) * 60 + Integer.parseInt(arr[2]);
	}
}