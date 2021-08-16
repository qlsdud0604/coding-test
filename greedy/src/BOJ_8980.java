import java.io.*;
import java.util.*;

public class BOJ_8980 {
	static int N; // 마을 수
	static int C; // 트럭의 용량
	static int M;

	static Box[] info; // 입력받은 박스의 정보
	static int[] arr; // 각 마을에서 실은 박스의 정보

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

	/** 트럭이 배송할 수 있는 최대 박스 수 계산 */
	static int function() {
		int result = 0;

		for (int i = 0; i < M; i++) {
			int start = info[i].start;
			int end = info[i].end;
			int count = info[i].count;

			int max = 0;
			boolean checked = true; // 실을 수 있는지 여부 판단

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

	/** 박스의 정보 */
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
