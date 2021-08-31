import java.util.*;

class Solution06 {
	static ArrayList<Music> arr = new ArrayList<>();

	static String[] sharp = { "C#", "D#", "F#", "G#", "A#" };
	static String[] lower = { "c", "d", "f", "g", "a" };

	public String solution(String m, String[] musicinfos) {

		/** ã���� �ϴ� ������ ���ڿ� ��ȯ */
		for (int i = 0; i < 5; i++)
			m = m.replace(sharp[i], lower[i]);

		/** �־��� ���� ������ Ž�� */
		for (int i = 0; i < musicinfos.length; i++) {

			String[] info = musicinfos[i].split(",");

			/* �ð� ���� */
			String[] startInfo = info[0].split(":");
			int startTime = Integer.parseInt(startInfo[0]) * 60 + Integer.parseInt(startInfo[1]);

			String[] endInfo = info[1].split(":");
			int endTime = Integer.parseInt(endInfo[0]) * 60 + Integer.parseInt(endInfo[1]);

			/* ���� ���� */
			String title = info[2];

			/* ��ε� ���� */
			String melody = info[3];

			/* ���� ��ε��� ���ڿ� ��ȯ */
			for (int j = 0; j < 5; j++)
				melody = melody.replace(sharp[j], lower[j]);

			arr.add(new Music(endTime - startTime, title, melody));
		}

		Collections.sort(arr);

		String answer = findMusic(m);

		return answer;
	}

	/** ���ǿ� �ش��ϴ� ���� ���� Ž�� */
	static String findMusic(String m) {
		String result = "(None)";

		for (int i = 0; i < arr.size(); i++) {
			String compare = "";

			int time = arr.get(i).time;
			String title = arr.get(i).title;
			String melody = arr.get(i).melody;

			/* �� ������ ��� �ð��� ã���� �ϴ� ������ ���̺��� ���� ��� */
			if (time < m.length())
				continue;

			/* ��� �ð���ŭ ���� �ݺ� */
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

	/** ���ǿ� ���� ���� */
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