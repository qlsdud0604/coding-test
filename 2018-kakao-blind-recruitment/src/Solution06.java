import java.util.*;

class Solution06 {
	static ArrayList<Music> arr = new ArrayList<>();

	static String[] sharp = { "C#", "D#", "F#", "G#", "A#" };
	static String[] lower = { "c", "d", "f", "g", "a" };

	public String solution(String m, String[] musicinfos) {

		/** 찾고자 하는 음악의 문자열 변환 */
		for (int i = 0; i < 5; i++)
			m = m.replace(sharp[i], lower[i]);

		/** 주어진 음악 정보의 탐색 */
		for (int i = 0; i < musicinfos.length; i++) {

			String[] info = musicinfos[i].split(",");

			/* 시간 정보 */
			String[] startInfo = info[0].split(":");
			int startTime = Integer.parseInt(startInfo[0]) * 60 + Integer.parseInt(startInfo[1]);

			String[] endInfo = info[1].split(":");
			int endTime = Integer.parseInt(endInfo[0]) * 60 + Integer.parseInt(endInfo[1]);

			/* 제목 정보 */
			String title = info[2];

			/* 멜로디 정보 */
			String melody = info[3];

			/* 비교할 멜로디의 문자열 변환 */
			for (int j = 0; j < 5; j++)
				melody = melody.replace(sharp[j], lower[j]);

			arr.add(new Music(endTime - startTime, title, melody));
		}

		Collections.sort(arr);

		String answer = findMusic(m);

		return answer;
	}

	/** 조건에 해당하는 음악 정보 탐색 */
	static String findMusic(String m) {
		String result = "(None)";

		for (int i = 0; i < arr.size(); i++) {
			String compare = "";

			int time = arr.get(i).time;
			String title = arr.get(i).title;
			String melody = arr.get(i).melody;

			/* 비교 음악의 재생 시간이 찾고자 하는 음악의 길이보다 작은 경우 */
			if (time < m.length())
				continue;

			/* 재생 시간만큼 음악 반복 */
			for (int j = 0; j < time / melody.length(); j++) {
				compare += melody;
			}

			for (int j = 0; j < time % melody.length(); j++) {
				compare += melody.charAt(j);
			}

			if (compare.contains(m)) {
				result = title;
				break;
			}
		}

		return result;
	}

	/** 음악에 대한 정보 */
	static class Music implements Comparable<Music> {
		int time;
		String title;
		String melody;

		Music(int time, String title, String melody) {
			this.time = time;
			this.title = title;
			this.melody = melody;
		}

		@Override
		public int compareTo(Music o) {
			return o.time - this.time;
		}
	}
}