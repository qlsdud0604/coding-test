import java.io.*;
import java.util.*;

public class BOJ_8980 {
	static int N; // ���� ��
	static int C; // Ʈ���� �뷮
	static int M;

	static Box[] info; // �Է¹��� �ڽ��� ����
	static int[] arr; // �� �������� ���� �ڽ��� ����

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(br.readLine());

		info = new Box[M];
		arr = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int count = Integer.parseInt(st.nextToken());

			info[i] = new Box(start, end, count);
		}

		Arrays.sort(info);

		bw.write(function() + "\n");
		bw.close();
	}

	/** Ʈ���� ����� �� �ִ� �ִ� �ڽ� �� ��� */
	static int function() {
		int result = 0;

		for (int i = 0; i < M; i++) {
			int start = info[i].start;
			int end = info[i].end;
			int count = info[i].count;

			int max = 0;
			boolean checked = true; // ���� �� �ִ��� ���� �Ǵ�

			for (int j = start; j < end; j++) {
				if (C <= arr[j]) {
					checked = false;
					break;
				}
				max = Math.max(max, arr[j]);
			}

			if (checked) {
				int unloads = C - max;

				if (count < unloads)
					unloads = count;

				result += unloads;

				for (int j = start; j < end; j++)
					arr[j] += unloads;
			}
		}

		return result;
	}

	/** �ڽ��� ���� */
	static class Box implements Comparable<Box> {
		int start;
		int end;
		int count;

		Box(int start, int end, int count) {
			this.start = start;
			this.end = end;
			this.count = count;
		}

		@Override
		public int compareTo(Box o) {
			if (this.end == o.end)
				return this.start - o.start;

			return this.end - o.end;
		}
	}

}
