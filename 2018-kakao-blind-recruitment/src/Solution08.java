import java.util.*;

public class Solution08 {
	public String[] solution(String[] files) {

		ArrayList<File> temp = new ArrayList<>();
		String[] answer = new String[files.length];

		StringBuilder sb;

		/** head, number, tail ���� */
		for (int i = 0; i < files.length; i++) {
			String file = files[i];

			int index = 0;

			/* ���ϸ��� head �κ� Ž�� */
			sb = new StringBuilder();

			for (int j = index; j < file.length(); j++) {
				if (file.charAt(j) < '0' || '9' < file.charAt(j)) {
					index++;
					sb.append(file.charAt(j));
				} else
					break;
			}
			String head = sb.toString();

			/* ���ϸ��� number �κ� Ž�� */
			sb = new StringBuilder();

			for (int j = index; j < file.length(); j++) {
				if ('0' <= file.charAt(j) && file.charAt(j) <= '9') {
					index++;
					sb.append(file.charAt(j));
				} else
					break;
			}
			String number = sb.toString();

			/* ���ϸ��� tail �κ� Ž�� */
			String tail = file.substring(index);

			temp.add(new File(head, number, tail));
		}

		Collections.sort(temp);

		for (int i = 0; i < files.length; i++) {
			answer[i] = temp.get(i).getFile();
		}

		return answer;
	}

	/** ���Ͽ� ���� ���� */
	static class File implements Comparable<File> {
		String head;
		String number;
		String tail;

		File(String head, String number, String tail) {
			this.head = head;
			this.number = number;
			this.tail = tail;
		}

		String getFile() {
			return head + number + tail;
		}

		@Override
		public int compareTo(File o) {

			if (this.head.equalsIgnoreCase(o.head))
				return Integer.parseInt(this.number) - Integer.parseInt(o.number);
			else
				return this.head.compareToIgnoreCase(o.head);
		}
	}
}
