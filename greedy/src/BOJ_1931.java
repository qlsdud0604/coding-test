import java.io.*;
import java.util.*;

public class BOJ_1931 {
	static int N;
	static Meeting[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new Meeting[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int finish = Integer.parseInt(st.nextToken());

			arr[i] = new Meeting(start, finish);
		}

		Arrays.sort(arr);

		bw.write(function() + "\n");
		bw.close();
	}

	/* 최대 회의의 개수 구하기 */
	static int function() {
		int result = 1;

		int currentFinish = arr[0].finish;

		for (int i = 1; i < N; i++) {
			if (currentFinish <= arr[i].start) {
				result++;
				currentFinish = arr[i].finish;
			}
		}

		return result;
	}

	/* 각 회의의 정보 */
	static class Meeting implements Comparable<Meeting> {
		int start;
		int finish;

		Meeting(int start, int finish) {
			this.start = start;
			this.finish = finish;
		}

		@Override
		public int compareTo(Meeting o) {

			if (this.finish == o.finish)
				return this.start - o.start;

			return this.finish - o.finish;
		}
	}

}
